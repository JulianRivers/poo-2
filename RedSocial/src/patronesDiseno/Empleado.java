/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patronesDiseno;

/**
 *
 * @author Julian
 */
public abstract class Empleado {
    private String nombre;
    private double salario;
    private String local;
    private String directorVirtual;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDirectorVirtual() {
        return directorVirtual;
    }

    public void setDirectorVirtual(String directorVirtual) {
        this.directorVirtual = directorVirtual;
    }
   
}
