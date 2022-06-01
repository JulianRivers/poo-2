/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redSocial.model.dao;

import java.util.Calendar;

/**
 *
 * @author Julian
 */
public class PublicacionDTO {

    static private int id;
    private String texto;
    private Calendar fechaPublicacion;
    private String usuario;


    public PublicacionDTO(String texto, Calendar fechaPublicacion, String usuario) {
        id++;
        this.texto = texto;
        this.fechaPublicacion = fechaPublicacion;
        this.usuario = usuario;
    }

    public PublicacionDTO() {
    }

    public long getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Calendar getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Calendar fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
