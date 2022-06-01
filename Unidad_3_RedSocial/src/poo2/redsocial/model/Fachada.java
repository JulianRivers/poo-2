package poo2.redsocial.model;

import java.util.ArrayList;

public class Fachada {

    // Patrón Singleton
    private static Fachada instance;
    private UsuarioDAO usuarioDAO;
    private PublicacionDAO publicacionDAO;

    private Fachada() {
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

    public ArrayList<UsuarioDTO> listarUsuarios() {
        ArrayList<UsuarioDTO> listaUsuarios = null;
        if (usuarioDAO != null) {
            listaUsuarios = usuarioDAO.obtenerUsuarios();
        }
        return listaUsuarios;
    }

    private void realizarCargaInicial() {
        usuarioDAO.crearUsuario("Boris Perez", "El Profe");
        usuarioDAO.crearUsuario("Susana Segura", "La Segura");
        usuarioDAO.crearUsuario("Mia Kalifa", "La Exnopor");
        usuarioDAO.crearUsuario("Johnny Sins", "El Bombero");

        publicacionDAO.crearPublicacion("Boris Perez", "Mi primera publicacion. Esto está genial");
        publicacionDAO.crearPublicacion("Susana Segura", "La verdad esto es como aburrido, hay alguien por acá?");
        publicacionDAO.crearPublicacion("Johnny Sins", "Woa, un nuevo lugar para hacer amigos. Me gusta conocer gente");
        publicacionDAO.crearPublicacion("Boris Perez", "No tengo amigos, pero ahí vamos");
        publicacionDAO.crearPublicacion("Susana Segura", "Estoy probando la red social. ");
        publicacionDAO.crearPublicacion("Johnny Sins", "Anoche la pasé mal, no pude dormir de lado, me dio un calambre");
        publicacionDAO.crearPublicacion("Boris Perez", "Esto se puso como aburrido la verdad");
        publicacionDAO.crearPublicacion("Susana Segura", "Creo que me saldré de esto, debe haber algo mejor para hacer afuera");
        publicacionDAO.crearPublicacion("Johnny Sins", "Yah bueno, cero gente, para qué crearon esto?");
    }

    public ArrayList<PublicacionDTO> listarPublicacionesUsuario(String usuario) {

        ArrayList<PublicacionDTO> listaPublicaciones = publicacionDAO.listarPublicacionesUsuario(usuario);
        return listaPublicaciones;

    }

    public void crearPublicacion(String nombres, String texto) {
        publicacionDAO.crearPublicacion(nombres, texto);
    }

}
