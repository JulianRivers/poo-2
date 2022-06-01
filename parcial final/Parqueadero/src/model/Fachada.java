package model;

import controllers.ControllerInterface;
import controllers.ControllerPool;
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.DAO.*;
import model.DTO.*;
import model.factory.*;
import util.UtilidadesVista;

public class Fachada extends UnicastRemoteObject implements ControllerInterface {

	private static final long serialVersionUID = 1L;
	private ControllerInterface servidorObj;
	private static Fachada instance;
	private static ArrayList<ControllerInterface> suscriptores;

	private Fachada() throws RemoteException {
		suscriptores = new ArrayList<ControllerInterface>();
		try {
			String dirIP = (InetAddress.getLocalHost()).toString();
			System.out.println("Escuchando en " + dirIP + ":" + 3232);
			Registry registry = LocateRegistry.createRegistry(3232);
			registry.bind("servidoramigo", (ControllerInterface) this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Fachada getInstance() throws RemoteException {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}

	public ArrayList<String> listarMarcas() throws SQLException {
		MarcaDAO newDAO = new MarcaDAO();

		return newDAO.listarMarcas();
	}

	public ArrayList<String> listarNoPuertas() {
		ArrayList<String> puertas = new ArrayList<String>();
		puertas.add("2");
		puertas.add("3");
		puertas.add("4");
		puertas.add("5");
		return puertas;
	}

	public ArrayList<String> listarTipoMotos() {
		ArrayList<String> tipos = new ArrayList<String>();
		tipos.add("Urbana");
		tipos.add("Carretera");
		tipos.add("Callejera");
		return tipos;
	}

	public ArrayList<String> listarTipoBicicletas() {
		ArrayList<String> tipos = new ArrayList<String>();
		tipos.add("MontaÃ±era");
		tipos.add("Ruta");
		tipos.add("Electrica");
		return tipos;
	}

	public ArrayList<String> listarCilindraje(byte vehiculo) {
		ArrayList<String> cilindrajes = new ArrayList<String>();
		switch (vehiculo) {
		case 1:// 1000, 1200, 1500 y 2000
			cilindrajes.add("1000");
			cilindrajes.add("1200");
			cilindrajes.add("1500");
			cilindrajes.add("2000");
			break;
		case 2:// 200, 300 y 400
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

	public ArrayList<String> listarModelo() {
		ArrayList<String> modelos = new ArrayList<String>();
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

	public ArrayList<String> listarVehiculos() throws SQLException, RemoteException {
		CarroDAO newCarroDAO = new CarroDAO();
		MotoDAO newMotoDAO = new MotoDAO();
		BicicletaDAO newBiciDAO = new BicicletaDAO();

		ArrayList<String> vehiculos = new ArrayList<String>();
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

	public VehiculoDTO ingresarVehiculo(int marca, String propietario, String tipo, byte vehiculo) {

		VehiculoFactory factory = this.inicializarFabrica(vehiculo);
		try {
			BicicletaAdapterDTO dto = (BicicletaAdapterDTO) factory.crearVehiculo();
			BicicletaDAO dao = new BicicletaDAO();

			dto.setCcPropietarioB(propietario);
			dto.setMarca(marca);
			dto.setTipoB(tipo);
			LocalDateTime dateTime = LocalDateTime.now();
			String timeStamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(dateTime);
			dto.setLlegada(timeStamp);
			dto.setPlaca("" + dao.crearBicicleta(dto));
			notifyControllers("Bicicleta");
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public VehiculoDTO ingresarVehiculo(String placa, int marca, int modelo, int cilindraje, int noPuertas,
			byte vehiculo) {

		VehiculoFactory factory = this.inicializarFabrica(vehiculo);

		CarroDTO dto;
		try {
			dto = (CarroDTO) factory.crearVehiculo();
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
			notifyControllers("Carro");
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public VehiculoDTO ingresarVehiculo(String placa, int marca, int modelo, int cilindraje, String tipo,
			byte vehiculo) {

		VehiculoFactory factory = this.inicializarFabrica(vehiculo);

		MotoDTO dto;
		try {
			dto = (MotoDTO) factory.crearVehiculo();
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
			notifyControllers("Moto");
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void addController(ControllerInterface conIn) {
		System.out.println("Controlador = " + conIn);
		suscriptores.add(conIn);
		System.out.println("Suscripción realizada: " + conIn.getClass().getName());
	}

	public void removeController(ControllerInterface conIn) {
		suscriptores.remove(conIn);
	}

	public void notifyControllers(String msg) {
		for (ControllerInterface conIn : suscriptores) {
			try {
				conIn.update(msg);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Notificando... " + msg);

	}

	@Override
	public void update(String arg0) {

	}

	@Override
	public void suscribirse(String arg0, ControllerInterface arg1) throws RemoteException {
		System.out.println("Estoy suscribiendo a mi arreglo " + arg0 + " que es el obj: " + arg1);
		ControllerPool.getInstance().addController(arg0, arg1);

	}

	public static ArrayList<ControllerInterface> getSuscriptores() {
		return suscriptores;
	}

	public void setSuscriptores(ArrayList<ControllerInterface> suscriptores) {
		this.suscriptores = suscriptores;
	}
	

}
