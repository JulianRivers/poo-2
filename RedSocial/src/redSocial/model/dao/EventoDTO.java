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
public class EventoDTO extends PublicacionDTO{
    private int numCupos;

    public EventoDTO( String texto, Calendar fechaPublicacion, String usuario, int numCupos) {
        super(texto, fechaPublicacion, usuario);
        this.numCupos = numCupos;
    }

    public int getNumCupos() {
        return numCupos;
    }

    public void setNumCupos(int numCupos) {
        this.numCupos = numCupos;
    }
    
}
