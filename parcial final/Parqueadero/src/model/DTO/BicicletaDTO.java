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
public class BicicletaDTO {

    private String ccPropietario, marca, tipo;
    
    public void setCcPropietario(String ccPropietario) {
        this.ccPropietario = ccPropietario;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCcPropietario() {
        return ccPropietario;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipo() {
        return tipo;
    }

}
