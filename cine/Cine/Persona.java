package Cine;

import java.util.Date;

public class Persona
{
    protected String nombre;
    protected String apellido;
    protected Date fechaNacimiento;
    protected String nacionalidad;

    public Persona(String nombre, String apellido, Date fechaNacimiento, String nacionalidad)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
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