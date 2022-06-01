/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redSocial.model;

import java.util.ArrayList;
import java.util.Calendar;
import redSocial.model.dao.PublicacionDAO;
import redSocial.model.dao.PublicacionDTO;
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
    private PublicacionDAO publicacionDAO;

    public Fachada() {
        usuarioDAO = new UsuarioDAO();
        publicacionDAO = new PublicacionDAO();
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

    public void crearGrupo(String nombre, String descripcion, String tipoGrupo) {
        usuarioDAO.crearGrupos(nombre, descripcion, tipoGrupo);
    }

    public void crearUsuario(String nombres, String apellidos, int edad, String email, String nick, String clave) {
        usuarioDAO.crearUsuario(nombres, apellidos, edad, email, nick, clave);
    }

    public void crearPublicacion(String texto, String usuario) {
        publicacionDAO.crearPublicacion(texto, usuario);
    }

    public void crearPublicacion(String texto, String usuario, int numCupos) {
        publicacionDAO.crearPublicacion(texto, usuario, numCupos);
    }

    public void crearPublicacion(String texto, String usuario, String url) {
        publicacionDAO.crearPublicacion(texto, usuario, url);
    }


    public UsuarioDTO buscarUsuario(String usuario) {
        return usuarioDAO.buscarUsuario(usuario);
    }

    public ArrayList<UsuarioDTO> listarUsuarios() {
        ArrayList<UsuarioDTO> listaUsuarios = null;
        if (usuarioDAO != null) {
            listaUsuarios = usuarioDAO.getUsuarios();
        }
        return listaUsuarios;
    }

    public boolean existeUsuario(String nick, String email) {
        return usuarioDAO.existeUsuario(nick, email);
    }

    public ArrayList<PublicacionDTO> listarPublicacionesUsuario(String usuario) {

        ArrayList<PublicacionDTO> listaPublicaciones = publicacionDAO.listarPublicacionesUsuario(usuario);
        return listaPublicaciones;

    }

    public void unirseGrupo(String nombre) {
        usuarioDAO.unirseGrupo(nombre);
    }

    private void realizarCargaInicial() {
        usuarioDAO.crearUsuario("Boris", "Perez", 37, "borisperez@gmail.com", "El Profe", "123");
        usuarioDAO.crearUsuario("Susana", "Segura", 24, "aseguradora@gmail.com", "La Segura",Integer.toString((int) Math.floor(Math.random())));
        usuarioDAO.crearUsuario("Mia", "Kalifa", 36, "soyunasucia@xvideos.com", "La Exnopor", "mia123");
        usuarioDAO.crearUsuario("Johnny", "Sins", 26, "Jhonnybravo@gmailcom", "El Bombero", "jhonny123");
        usuarioDAO.crearUsuario("Julian", "Riveros", 18, "riverosfonsecajuliancamilo@gmailcom", "1", "1");
        usuarioDAO.crearUsuario("Samuel", "Riveros", 12, "2", "2", "2");
        usuarioDAO.crearGrupos("furros", "furrasos", "xdddd");
        usuarioDAO.crearGrupos("alo", "buenas", "noches");
        usuarioDAO.crearGrupos("maincra", "Seguir las reglas del grupo", "Juegos");
        publicacionDAO.crearPublicacion("Hola, por qué esta red social tiene un logo tan feo?", "1");
        publicacionDAO.crearPublicacion("La verdad esto es como aburrido, hay alguien por acá?", "La Segura");
        publicacionDAO.crearPublicacion("Woa, un nuevo lugar para hacer amigos. Me gusta conocer gente", "El Bombrero");
        publicacionDAO.crearPublicacion("No tengo amigos, pero ahí vamos", "El Profe");
        publicacionDAO.crearPublicacion("Estoy probando la red social.", "La Segura");
        publicacionDAO.crearPublicacion("Anoche la pasé mal, no pude dormir de lado, me dio un calambre", "El Bombero");
        publicacionDAO.crearPublicacion("Esto se puso como aburrido la verdad", "El Profe");
        publicacionDAO.crearPublicacion("Creo que me saldré de esto, debe haber algo mejor para hacer afuera", "La Segura");
        publicacionDAO.crearPublicacion("Yah bueno, cero gente, para qué crearon esto?", "El Bombero");
    }
}
