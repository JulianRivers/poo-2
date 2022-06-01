/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parque;

import java.util.ArrayList;


public class ParqueAtracciones {
    
    String ubicacionReal;
    ArrayList<Atraccion> atracciones = new ArrayList();

    public String getUbicacionReal() {
        return ubicacionReal;
    }

    public void setUbicacionReal(String ubicacionReal) {
        this.ubicacionReal = ubicacionReal;
    }

    public ArrayList<Atraccion> getAtracciones() {
        return atracciones;
    }

    public void setAtracciones(ArrayList<Atraccion> atracciones) {
        this.atracciones = atracciones;
    }
    public void addAtracciones(Atraccion a){
        atracciones.add(a);
    }
}
