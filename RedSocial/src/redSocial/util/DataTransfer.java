package redSocial.util;

import java.util.ArrayList;
import redSocial.model.dao.GrupoDTO;
import redSocial.model.dao.UsuarioDTO;

public class DataTransfer {

    private String nombreCompleto;
    private String id;
    private int edad;
    private String nick;
    private String email;
    private static DataTransfer instance;
    private ArrayList<GrupoDTO> grupos = new ArrayList();
    private ArrayList<GrupoDTO> gruposPerteneces = new ArrayList();

    private DataTransfer() {
    }

    public static DataTransfer getInstance() {
        if (instance == null) {
            instance = new DataTransfer();
        }
        return instance;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public ArrayList<GrupoDTO> getGrupos() {
        return grupos;
    }

    public void setGrupos(ArrayList<GrupoDTO> grupos) {
        this.grupos = grupos;
    }

    public ArrayList<GrupoDTO> getGruposPerteneces() {
        return gruposPerteneces;
    }

    public void setGruposPerteneces(ArrayList<GrupoDTO> gruposPerteneces) {
        this.gruposPerteneces = gruposPerteneces;
    }


}
