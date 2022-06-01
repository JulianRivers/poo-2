package poo2.redsocial.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class PublicacionDAO {

	private HashMap<String, ArrayList<PublicacionDTO>> listaPublicaciones;
	
	public PublicacionDAO() {
		listaPublicaciones = new HashMap<String, ArrayList<PublicacionDTO>>();
	}
	
	public void crearPublicacion(String usuario, String texto) {
		PublicacionDTO dto = new PublicacionDTO();
		
		dto.setUsuario(usuario);
		dto.setTexto(texto);
		dto.setFechaPublicacion(Calendar.getInstance());
		dto.setId(Calendar.getInstance().getTimeInMillis());
		
		ArrayList<PublicacionDTO> lista = listaPublicaciones.get(usuario);
		if(lista==null)
			lista = new ArrayList<PublicacionDTO>();
		
		lista.add(dto);
		
		listaPublicaciones.put(usuario, lista);
	}
	
	public ArrayList<PublicacionDTO> listarPublicacionesUsuario(String usuario){
		ArrayList<PublicacionDTO> lista = listaPublicaciones.get(usuario);
		
		return lista;
	}
	
	
}
