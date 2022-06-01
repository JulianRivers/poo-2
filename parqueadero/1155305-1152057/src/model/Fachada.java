package model;

import controllers.ControllerInterface;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.DAO.BicicletaDAO;
import model.DAO.CarroDAO;
import model.DTO.CarroDTO;
import model.DAO.MarcaDAO;
import model.DAO.MotoDAO;
import model.DTO.BicicletaAdapterDTO;
import model.DTO.MotoDTO;
import model.DTO.VehiculoDTO;
import model.factory.BicicletaAdapterFactory;
import model.factory.CarroFactory;
import model.factory.MotoFactory;
import model.factory.VehiculoFactory;
import util.UtilidadesVista;

public class Fachada {

    private static Fachada instance;
    private ArrayList<ControllerInterface> suscriptores;

    private Fachada() {
        suscriptores = new ArrayList();
    }

    public static Fachada getInstance() {
        if (instance == null) {
            instance = new Fachada();
        }
        return instance;
    }

    public ArrayList listarMarcas() throws SQLException {
        MarcaDAO newDAO = new MarcaDAO();

        return newDAO.listarMarcas();
    }

    public ArrayList listarNoPuertas() {
        ArrayList puertas = new ArrayList();
        puertas.add("2");
        puertas.add("3");
        puertas.add("4");
        puertas.add("5");
        return puertas;
    }

    public ArrayList listarTipoMotos() {
        ArrayList<String> tipos = new ArrayList();
        tipos.add("Urbana");
        tipos.add("Carretera");
        tipos.add("Callejera");
        return tipos;
    }

    public ArrayList listarTipoBicicletas() {
        ArrayList<String> tipos = new ArrayList();
        tipos.add("Montañera");
        tipos.add("Ruta");
        tipos.add("Electrica");
        return tipos;
    }

    public ArrayList listarCilindraje(byte vehiculo) {
        ArrayList<String> cilindrajes = new ArrayList();
        switch (vehiculo) {
            case 1://1000, 1200, 1500 y 2000
                cilindrajes.add("1000");
                cilindrajes.add("1200");
                cilindrajes.add("1500");
                cilindrajes.add("2000");
                break;
            case 2://200, 300 y 400
                cilindrajes.add("200");
                cilindrajes.add("300");
                cilindrajes.add("400");
                break;
            case 3:
                cilindrajes.add("50");
                cilindrajes.add("40");
                cilindrajes.add("30");
                cilindrajes.add("25");
                break;
            default:
                throw new AssertionError();
        }
        return cilindrajes;
    }

    public ArrayList listarModelo() {
        ArrayList<String> modelos = new ArrayList();
        modelos.add("1999");
        modelos.add("2000");
        modelos.add("2001");
        modelos.add("2002");
        modelos.add("2003");
        modelos.add("2004");
        modelos.add("2005");
        modelos.add("2006");
        modelos.add("2007");
        modelos.add("2008");
        modelos.add("2009");
        modelos.add("2010");
        modelos.add("2011");
        modelos.add("2012");
        modelos.add("2013");
        modelos.add("2014");
        modelos.add("2015");
        modelos.add("2016");
        modelos.add("2017");
        modelos.add("2018");
        modelos.add("2019");
        modelos.add("2020");
        modelos.add("2021");

        return modelos;
    }

    public ArrayList listarVehiculos() throws SQLException {
        CarroDAO newCarroDAO = new CarroDAO();
        MotoDAO newMotoDAO = new MotoDAO();
        BicicletaDAO newBiciDAO = new BicicletaDAO();

        ArrayList vehiculos = new ArrayList();
        vehiculos.addAll(newCarroDAO.listarVehiculos((byte) 1));
        vehiculos.addAll(newMotoDAO.listarVehiculos((byte) 2));
        vehiculos.addAll(newBiciDAO.listarVehiculos((byte) 3));

        return vehiculos;
    }

    public VehiculoFactory inicializarFabrica(byte vehiculo) {
        VehiculoFactory factory = null;
        switch (vehiculo) {
            case 1:
                factory = new CarroFactory();
                break;
            case 2:
                factory = new MotoFactory();
                break;
            case 3:
                factory = new BicicletaAdapterFactory();
                break;
            default:
                throw new AssertionError();
        }
        return factory;
    }

    public VehiculoDTO ingresarVehiculo(int marca, String propietario, String tipo,
            byte vehiculo) throws Exception {

        VehiculoFactory factory = this.inicializarFabrica(vehiculo);
        notifyControllers(UtilidadesVista.traducirTipoVehiculo(vehiculo));
        BicicletaAdapterDTO dto = (BicicletaAdapterDTO) factory.crearVehiculo();
        BicicletaDAO dao = new BicicletaDAO();

        dto.setCcPropietarioB(propietario);
        dto.setMarca(marca);
        dto.setTipoB(tipo);
        LocalDateTime dateTime = LocalDateTime.now();
        String timeStamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(dateTime);
        dto.setLlegada(timeStamp);

        dto.setPlaca("" + dao.crearBicicleta(dto));
        return dto;
    }

    public VehiculoDTO ingresarVehiculo(String placa, int marca, int modelo, int cilindraje,
            int noPuertas, byte vehiculo) throws Exception {

        VehiculoFactory factory = this.inicializarFabrica(vehiculo);
        notifyControllers(UtilidadesVista.traducirTipoVehiculo(vehiculo));
        CarroDTO dto = (CarroDTO) factory.crearVehiculo();
        CarroDAO dao = new CarroDAO();

        dto.setPlaca(placa);
        dto.setMarca(marca);
        dto.setModelo(modelo);
        dto.setCilindraje(cilindraje);
        dto.setNoPuertas(noPuertas);
        LocalDateTime dateTime = LocalDateTime.now();
        String timeStamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(dateTime);
        dto.setLlegada(timeStamp);

        dao.crearCarro(dto);
        return dto;
    }

    public VehiculoDTO ingresarVehiculo(String placa, int marca, int modelo, int cilindraje, String tipo,
            byte vehiculo) throws Exception {

        VehiculoFactory factory = this.inicializarFabrica(vehiculo);
        notifyControllers(UtilidadesVista.traducirTipoVehiculo(vehiculo));
        MotoDTO dto = (MotoDTO) factory.crearVehiculo();
        MotoDAO dao = new MotoDAO();

        dto.setPlaca(placa);
        dto.setMarca(marca);
        dto.setModelo(modelo);
        dto.setCilindraje(cilindraje);
        dto.setTipo(tipo);
        LocalDateTime dateTime = LocalDateTime.now();
        String timeStamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(dateTime);
        dto.setLlegada(timeStamp);

        dao.crearMoto(dto);
        return dto;
    }

    public void addController(ControllerInterface conIn) {
        suscriptores.add(conIn);
        System.out.println("Suscripción realizada");
    }

    public void removeController(ControllerInterface conIn) {
        suscriptores.remove(conIn);
    }

    public void notifyControllers(String msg) {

        System.out.println("Notificando... ");

        for (ControllerInterface conIn : suscriptores) {
            conIn.update(msg);
        }

    }
}
