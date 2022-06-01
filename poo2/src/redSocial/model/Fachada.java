/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redSocial.model;

import java.util.ArrayList;
import redSocial.model.dao.UsuarioDAO;
import redSocial.model.dao.UsuarioDTO;
import redSocial.util.DataTransfer;

/**
 *
 * @author Julian
 */
public class Fachada {

    private static Fachada instance;
    private UsuarioDAO usuarioDAO;

    public Fachada() {
        usuarioDAO = new UsuarioDAO();
        realizarCargaInicial();
    }

    public static Fachada getInstance() {
        if (instance == null) {
            instance = new Fachada();
        }
        return instance;
    }

    public String getWelcomeText() {
        return "Sistema de información personal y de gestión";
    }

    public UsuarioDTO validarCredenciales(String usuario, String passwd) throws Exception {
        UsuarioDTO dto = usuarioDAO.validarCredenciales(usuario, passwd);
        return dto;
    }

    public void crearUsuario(String nombres, String apellidos, int edad, String email, String nick, String clave) {
        usuarioDAO.crearUsuario(nombres, apellidos, edad, email, nick, clave);
    }

    public UsuarioDTO addAmigos(String busqueda) {
        return usuarioDAO.agregarAmigo(busqueda);
    }

    public UsuarioDTO buscarUsuario(String usuario) {
        return usuarioDAO.buscarUsuario(usuario);
    }

    private void realizarCargaInicial() {
        usuarioDAO.crearUsuario("Boris", "Perez", 37, "borisperez@gmail.com", "El Profe", "123");
        usuarioDAO.crearUsuario("Susana", "Segura", 24, "aseguradora@gmail.com", "La Segura", "v!E6CotzcK%KysEi");
        usuarioDAO.crearUsuario("Mia", "Kalifa", 36, "soyunasucia@xvideos.com", "La Exnopor", "mia123");
        usuarioDAO.crearUsuario("Johnny", "Sins", 26, "Jhonnybravo@gmailcom", "El Bombero", "jhonny123");
        usuarioDAO.crearUsuario("Julian", "Riveros", 18, "1", "1", "1");
        usuarioDAO.crearUsuario("Samuel", "Riveros", 12, "2", "2", "2");

    }

    public boolean existeUsuario(String nick, String email) {
        return usuarioDAO.existeUsuario(nick, email);
    }

    public boolean validarAmigo(String busqueda) {
        if (usuarioDAO.buscarUsuario(busqueda) != null) {
                return DataTransfer.getInstance().getAmigos().contains(buscarUsuario(busqueda));
        }
        return false;
    }
}
