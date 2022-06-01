/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redSocial.model.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import redSocial.util.DataTransfer;

/**
 *
 * @author Julian
 */
public class PublicacionDAO {

    private HashMap<String, ArrayList<PublicacionDTO>> listaPublicaciones;

    public PublicacionDAO() {
        listaPublicaciones = new HashMap<String, ArrayList<PublicacionDTO>>();
    }

    public void crearPublicacion(String texto, String usuario) {
        PublicacionDTO dto = new PublicacionDTO();

        dto.setUsuario(usuario);
        dto.setTexto(texto);
        dto.setFechaPublicacion(Calendar.getInstance());

        ArrayList<PublicacionDTO> lista = listaPublicaciones.get(usuario);
        if (lista == null) {
            lista = new ArrayList<PublicacionDTO>();
        }

        lista.add(dto);

        listaPublicaciones.put(usuario, lista);
    }

    public void crearPublicacion(String texto, String usuario, int numCupos) {
        PublicacionDTO dto = new EventoDTO(texto, Calendar.getInstance(), usuario, numCupos);

        ArrayList<PublicacionDTO> lista = listaPublicaciones.get(usuario);
        if (lista == null) {
            lista = new ArrayList<PublicacionDTO>();
        }
        lista.add(dto);
        listaPublicaciones.put(usuario, lista);
    }
    
    public void crearPublicacion(String texto, String usuario, String url) {
        PublicacionDTO dto = new EnlaceDTO(texto, Calendar.getInstance(), usuario, url);

        ArrayList<PublicacionDTO> lista = listaPublicaciones.get(usuario);
        if (lista == null) {
            lista = new ArrayList<PublicacionDTO>();
        }
        lista.add(dto);
        listaPublicaciones.put(usuario, lista);
    }

    public ArrayList<PublicacionDTO> listarPublicacionesUsuario(String usuario){
		ArrayList<PublicacionDTO> lista = listaPublicaciones.get(usuario);
		return lista;
	}
	
}
