/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redSocial.model.dao;

/**
 *
 * @author Julian
 */
public class AmigoDTO {
    
    private String nombres;
    private String apellidos;
    private int edad;
    private String email;
    private String nick;

    public AmigoDTO() {
    }

    public AmigoDTO(String nombres, String apellidos, int edad, String email, String nick) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.email = email;
        this.nick = nick;
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
    
    public String getNombreCompleto() {
        return nombres + " " + apellidos;
    }
}
