/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parque;

/**
 *
 * @author Julian
 */
public class Mecanismo {

    protected boolean estado;
    protected int capacidad;
    protected int posicion;

    public boolean isEstado() {
        return estado;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
}
