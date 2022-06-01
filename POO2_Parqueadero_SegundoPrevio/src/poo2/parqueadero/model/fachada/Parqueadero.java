package poo2.parqueadero.model.fachada;

import java.util.ArrayList;

import poo2.parqueadero.controllers.ControllerInterface;
import poo2.parqueadero.model.dao.CarroDAO;
import poo2.parqueadero.model.dao.MarcaDAO;
import poo2.parqueadero.model.dao.MotoDAO;
import poo2.parqueadero.model.dao.NuevoVehiculoDAO;
import poo2.parqueadero.model.dto.BicicletaDTOAdapter;
import poo2.parqueadero.model.dto.CarroDTO;
import poo2.parqueadero.model.dto.MarcaDTO;
import poo2.parqueadero.model.dto.MotoDTO;
import poo2.parqueadero.model.dto.VehiculoDTO;
import poo2.parqueadero.model.factory.BicicletaAdapterVehiculoFactory;
import poo2.parqueadero.model.factory.CarroVehiculoFactory;
import poo2.parqueadero.model.factory.MotoVehiculoFactory;
import poo2.parqueadero.model.factory.VehiculoFactory;

public class Parqueadero {

	
	private ArrayList<ControllerInterface> suscriptores;
	private VehiculoFactory vF;
	
	private static Parqueadero instance;
	
	private Parqueadero() {
		suscriptores = new ArrayList<ControllerInterface>();
	}
	
	public static Parqueadero getInstance() {
		if(instance==null)
			instance = new Parqueadero();
		
		return instance;
	}
	
	public ArrayList<String> listarMarcas(){
		MarcaDAO dao = new MarcaDAO();
		ArrayList<MarcaDTO> lista = dao.listar();
		
		ArrayList<String> listaNombres = null;
		if(lista!=null && lista.size()>0) {
			listaNombres = new ArrayList<String>();
			for(MarcaDTO dto : lista) {
				listaNombres.add(dto.getNombre());
			}
		}		
		
		return listaNombres;
	}
	
	public int obtenerIdMarca(String nombreMarca) {
		int idMarca = 0;
		
		MarcaDAO dao = new MarcaDAO();
		idMarca = dao.obtenerId(nombreMarca);
		
		return idMarca;
	}
	
	public void registrarEntradaVehiculo(String placa, String marca, String tipoBicicleta, String propietario, char tipoVehiculo) {
				
		vF = obtenerFactory(tipoVehiculo);
		
		if(tipoVehiculo=='c') {
			
			registrarCarro(placa, marca);
			notifyControllers("carro");
			
		}else if(tipoVehiculo=='m') {
			MotoDTO dto = (MotoDTO) vF.crearVehiculo();
			dto.setPlaca(placa);
			dto.setNombreMarca(marca);
			dto.setIdMarca(obtenerIdMarca(marca));
			
			MotoDAO dao = new MotoDAO();
			dao.agregar(dto);
			
			notifyControllers("moto");
			
		}else if(tipoVehiculo=='o') { // Otro vehiculo
			BicicletaDTOAdapter dto = (BicicletaDTOAdapter) vF.crearVehiculo();
			
			
			NuevoVehiculoDAO dao = new NuevoVehiculoDAO();
			dao.agregar(dto);
			
			notifyControllers("bicicleta");
			
		}
		
	}
	
	private boolean registrarCarro(String placa, String marca) {
		
		CarroDTO dto = (CarroDTO) vF.crearVehiculo();
		dto.setPlaca(placa);
		dto.setNombreMarca(marca);
		dto.setIdMarca(obtenerIdMarca(marca));
		
		CarroDAO dao = new CarroDAO();
		dao.agregar(dto);
		
		return false;
	}
	
	private VehiculoFactory obtenerFactory(char tipo) {
		VehiculoFactory vF = null;
		
		if(tipo=='c') {
			vF = new CarroVehiculoFactory();
		}else if(tipo=='m') {
			vF = new MotoVehiculoFactory();
		}else if(tipo=='o') {
			vF = new BicicletaAdapterVehiculoFactory();
		}
		
		return vF;
	}
	
	public ArrayList<VehiculoDTO> listarVehiculos(char tipo){
		ArrayList<VehiculoDTO> lista = null;
		
		if(tipo=='c') {
			lista = (new CarroDAO()).listar();
		}else if(tipo=='m') {
			lista = (new MotoDAO()).listar();
		} else if(tipo=='o') {
			lista = (new NuevoVehiculoDAO()).listar();
		} 
		
		return lista;
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
		
		for(ControllerInterface conIn : suscriptores) {
			conIn.update(msg);
		}
		
	}
	
}







