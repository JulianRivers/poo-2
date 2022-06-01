package redSocial.model.dao;

import java.util.ArrayList;
import java.util.List;

public class FuncionalidadDAO {

	public List<FuncionalidadDTO> listarFuncionalidades(String usuario){
		
		List<FuncionalidadDTO> lista = null;
		
		if(usuario.equals("1")) {
			lista = new ArrayList<FuncionalidadDTO>();
			
			
		}else if(usuario.equals("2")) {
			lista = new ArrayList<FuncionalidadDTO>();
		}
		
		return lista;
		
	}
	
}
