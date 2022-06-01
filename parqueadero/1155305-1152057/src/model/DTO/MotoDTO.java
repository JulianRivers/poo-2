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
public class MotoDTO extends VehiculoDTO{
    
    private String tipo;


    public MotoDTO() {
    }
    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }  

    @Override
    public String toString() {
        return "Moto - Placa: " + this.getPlaca() +" Llegada:" + this.getLlegada();
    }
}
