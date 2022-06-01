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

    public ArrayList<UsuarioDTO> getUsuarios() {
        return usuarios;
    }


    public void crearUsuario(String nombres, String apellidos, int edad, String email, String nick, String clave) {
        if (!existeUsuario(nick, email)) {
            UsuarioDTO user = new UsuarioDTO(nombres, apellidos, edad, email, nick, clave);
            usuarios.add(user);
            System.out.println("usuario creado con éxito.");
        }
    }

    public void crearGrupos(String nombre, String descripcion, String tipoGrupo) {
        GrupoDTO group = new GrupoDTO(nombre, descripcion, tipoGrupo);
        DataTransfer.getInstance().getGrupos().add(group);
        System.out.println("Grupo creado con éxito.");
    }

    public void unirseGrupo(String nombre) {
        DataTransfer.getInstance().getGruposPerteneces().add(buscarGrupo(nombre));
    }

    public GrupoDTO buscarGrupo(String grupo) {
        for (int i = 0; i < DataTransfer.getInstance().getGrupos().size(); i++) {
            if (grupo.equals(DataTransfer.getInstance().getGrupos())) {
                return DataTransfer.getInstance().getGrupos().get(i);
            }
        }
        return null;
    }
}
