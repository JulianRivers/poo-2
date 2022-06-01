package ufps.poo2.api;

public class Bicicleta{

    private String ccPropietario, marca, tipo;

    public void setCcPropietario(String ccPropietario){
        this.ccPropietario = ccPropietario;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String getCcPropietario(){
        return ccPropietario;
    }

    public String getMarca(){
        return marca;
    }

    public String getTipo(){
        return tipo;
    }

}