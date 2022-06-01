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
public class BicicletaAdapterDTO extends VehiculoDTO {

    private BicicletaDTO bicicleta;

    public BicicletaAdapterDTO() {
        bicicleta = new BicicletaDTO();
    }

    public void setCcPropietarioB(String ccPropietario) {
        bicicleta.setCcPropietario(ccPropietario);
    }

    public String getCcPropietarioB() {
        return bicicleta.getCcPropietario();
    }

    public void setTipoB(String tipo) {
        bicicleta.setTipo(tipo);
    }
    
    public String getTipoB() {
        return bicicleta.getTipo();
    }

    public void setMarcaB(String marca) {
        bicicleta.setMarca(marca);
    }

    public String getMarcaB(){
        return bicicleta.getMarca();
    }

    @Override
    public String toString() {
        return "Bicicleta - Id: "+ this.getPlaca()+" Llegada: "+this.getLlegada();
    }
    
    
}
