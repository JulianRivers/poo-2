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
public class GrupoDTO {
    
    private String nombre;
    private String descripcion;
    private String tipoGrupo;

    public GrupoDTO(String nombre, String descripcion, String tipoGrupo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoGrupo = tipoGrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoGrupo() {
        return tipoGrupo;
    }

    public void setTipoGrupo(String tipoGrupo) {
        this.tipoGrupo = tipoGrupo;
    }
    
}
