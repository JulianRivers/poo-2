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
public class Operario extends Persona{

    private double salario;
    private int id;
    private Dispositivo dispositivo;
    
    public Operario() {
        super();
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
