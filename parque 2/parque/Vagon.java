/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parque;

import java.util.ArrayList;

public class Vagon extends Mecanismo{

    
 public Vagon(){
     
      super(); 
 }
 
 public void crearMontaniaRusa(String ubicacion, Torniquete torniqueteEntrada, Torniquete torniqueteSalida, ArrayList<Vagon> vagones){
     MontaniaRusa mR = new MontaniaRusa();
     
     mR.setUbicacion(ubicacion);
     mR.setEstado(true);
     mR.setCantidadPasajero(0);
     mR.setCantidadVueltas(0);
     mR.setTorniqueteEntrada(torniqueteEntrada);
     mR.setTorniqueteSalida(torniqueteSalida);
     mR.setVagones(vagones);
 }
    
}