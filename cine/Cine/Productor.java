package Cine;

import java.util.Date;

public class Productor extends Persona{
    double salario;

    public Productor(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, double salario) {
        super(nombre, apellido, fechaNacimiento, nacionalidad);
    }
    
}