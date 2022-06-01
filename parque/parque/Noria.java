
package parque;

import java.util.ArrayList;


public class Noria extends Atraccion{
    
    ArrayList<Vehiculo> vehiculos = new ArrayList();
    
   public Noria(){
      super(); 
   }
 
   
    public int verificacionVehiculos(){
        int dañado = -1;
        for (int i = 0; i < vehiculos.size(); i++) {
            if(vehiculos.get(i).isEstado() == false){
                dañado = i;
                this.setEstado(false);
                torniqueteEntrada.setFase(false);
                break;
            }
        }
        return dañado;
     }
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
}