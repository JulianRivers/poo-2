package redSocial.model.dao;

import java.util.ArrayList;
import redSocial.model.Fachada;
import redSocial.util.DataTransfer;

public class UsuarioDAO {

    /**
     * Este metodo tiene como proposito validar las credenciales ingresadas por
     * el usuario.
     *
     * @param usuario
     * @param passwd
     * @return
     */
    ArrayList<UsuarioDTO> usuarios = new ArrayList();


    public UsuarioDTO validarCredenciales(String usuario, String passwd) {
        UsuarioDTO dto = null;
        dto = buscarUsuario(usuario, passwd);
        return dto;
    }

    public UsuarioDTO buscarUsuario(String usuario, String passwd) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuario.equals(usuarios.get(i).getNick()) && passwd.equals(usuarios.get(i).getClave())) {
                return usuarios.get(i);
            }
        }
        return null;
    }

   public UsuarioDTO buscarUsuario(String usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuario.equals(usuarios.get(i).getNick()) || usuario.equals(usuarios.get(i).getNombres())) {
                return usuarios.get(i);
            }
        }
        return null;
    }

    public boolean existeUsuario(String nick, String email) {
        return usuarios.contains(buscarUsuario(nick)) && usuarios.contains(buscarUsuario(email));
    }

    ArrayList<UsuarioDTO> getUsuarios() {
        return usuarios;
    }

    public UsuarioDTO agregarAmigo(String busqueda) {
        UsuarioDTO user = buscarUsuario(busqueda);
            if (!Fachada.getInstance().validarAmigo(busqueda)) {
                DataTransfer.getInstance().getAmigos().add(user);
            }
        return user;
    }

    public void crearUsuario(String nombres, String apellidos, int edad, String email, String nick, String clave) {
        if (!existeUsuario(nick, email)) {
            UsuarioDTO user = new UsuarioDTO(nombres, apellidos, edad, email, nick, clave);
            usuarios.add(user);
            System.out.println("usuario creado con éxito.");
        }
    }

}
