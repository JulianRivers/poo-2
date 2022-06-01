package poo2.redsocial.model;

import java.util.ArrayList;
import java.util.Calendar;

public class UsuarioDAO {

	public ArrayList<UsuarioDTO> listaUsuarios;
	
	public UsuarioDAO() {
		listaUsuarios = new ArrayList<UsuarioDTO>();
	}
	
	public void crearUsuario(String nombres, String apodo) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setApodo(apodo);
		dto.setNombres(nombres);
		dto.setId(Calendar.getInstance().getTimeInMillis());
		
		listaUsuarios.add(dto);
	}
	
	public ArrayList<UsuarioDTO> obtenerUsuarios(){
		return listaUsuarios;
	}
	
}
