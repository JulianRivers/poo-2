/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parque;

import java.util.ArrayList;

public class MontaniaRusa extends Atraccion{

    ArrayList<Vagon> vagones = new ArrayList();
    
   public MontaniaRusa(){
      super(); 
   }

    public int verificacionVagones(){
        int dañado = -1;
        for (int i = 0; i < vagones.size(); i++) {
            if(vagones.get(i).isEstado() == false){
                dañado = i;
                this.setEstado(false);
                torniqueteEntrada.setFase(false);
                break;
            }
        }
        return dañado;
     }

    public ArrayList<Vagon> getVagones() {
        return vagones;
    }

    public void setVagones(ArrayList<Vagon> vagones) {
        this.vagones = vagones;
    }

    }