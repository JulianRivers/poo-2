/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parque;

import java.util.ArrayList;

/**
 *
 * @author Julian
 */
public class Vehiculo extends Mecanismo{
    
    

    public Vehiculo() {
        super();
    }
    
 public void crearNoria(String ubicacion, Torniquete torniqueteEntrada, Torniquete torniqueteSalida, ArrayList<Vehiculo> vehiculo){
     Noria n = new Noria();
     
     n.setUbicacion(ubicacion);
     n.setEstado(true);
     n.setCantidadPasajero(0);
     n.setCantidadVueltas(0);
     n.setTorniqueteEntrada(torniqueteEntrada);
     n.setTorniqueteSalida(torniqueteSalida);
     n.setVehiculos(vehiculo);
 }
 
}
