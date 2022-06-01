package Cine;

import java.util.Date;

public class Director extends Persona
{
    double salario;
    public Director(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, double salario) 
    {
        super(nombre, apellido, fechaNacimiento, nacionalidad);
    }    
}

