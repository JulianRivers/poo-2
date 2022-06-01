/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redSocial.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Julian
 */
public class AmigosDAO {

    private HashMap<String, ArrayList<AmigoDTO>> listaAmigos;

    public AmigosDAO() {
        this.listaAmigos = new HashMap<>();
    }

    public void addAmigo(String amigo, String usuario) {
        AmigoDTO dto = new AmigoDTO();
        AmigoDTO dto2 = new AmigoDTO();

        ArrayList<AmigoDTO> listaUsuario = listaAmigos.get(usuario);
        ArrayList<AmigoDTO> listaAmigo = listaAmigos.get(amigo);
        if (listaUsuario == null) {
            listaUsuario = new ArrayList<>();
        }
        if (listaUsuario == null) {
            listaAmigo = new ArrayList<>();
        }

        listaUsuario.add(dto);
        listaAmigo.add(dto2);

        listaAmigos.put(usuario, listaUsuario);
    }

}
