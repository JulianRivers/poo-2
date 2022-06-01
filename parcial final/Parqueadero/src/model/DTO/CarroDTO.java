/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DTO;

/**
 *
 * @author Julian
 */
public class CarroDTO extends VehiculoDTO {

    private int noPuertas;


    public CarroDTO() {
    }

    public int getNoPuertas() {
        return noPuertas;
    }

    public void setNoPuertas(int noPuertas) {
        this.noPuertas = noPuertas;
    } 
    
    @Override
    public String toString() {
        return "Carro - Placa: " + this.getPlaca() +" Llegada: " + this.getLlegada();
    }
}
