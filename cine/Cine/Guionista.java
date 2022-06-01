package Cine;

import java.util.Date;

public class Guionista extends Persona
{
    double salario;

    public Guionista(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, double salario) 
    {
        super(nombre, apellido, fechaNacimiento, nacionalidad);
        this.salario = salario;
    }
    
    public double getSalario() 
    {
        return salario;
    }

    public void setSalario(double salario) 
    {
        this.salario = salario;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getApellido() 
    {
        return apellido;
    }

    public void setApellido(String apellido) 
    {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() 
    {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) 
    {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() 
    {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) 
    {
        this.nacionalidad = nacionalidad;
    }
}