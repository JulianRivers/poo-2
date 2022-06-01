package redSocial.model.dao;

import java.util.ArrayList;

public class UsuarioDTO {

    private String nombres;
    private String apellidos;
    private String id;
    private int edad;
    private String email;
    private String nick;
    private String clave;

    public UsuarioDTO(String nombres, String apellidos, int edad, String email, String nick, String clave) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        id = nick.replace(" ","") +(int) Math.floor(Math.random()*edad*10+1) +edad ;
        this.edad = edad;
        this.email = email;
        this.nick = nick;
        this.clave = clave;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombreCompleto() {
        return nombres + " " + apellidos;
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

}
