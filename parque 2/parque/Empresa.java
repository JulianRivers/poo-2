package parque;

import java.util.ArrayList;

public class Empresa {
    
    private String nombre;
    private ArrayList<Operario> operarios = new ArrayList();
    private ArrayList<ParqueAtracciones> parqueAtracciones = new ArrayList();


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Operario> getOperarios() {
        return operarios;
    }

    public void addOperarios(Operario o) {
        operarios.add(o);
    }

    public ArrayList<ParqueAtracciones> getParqueAtracciones() {
        return parqueAtracciones;
    }

    public void addParqueAtracciones(ParqueAtracciones pA) {
        parqueAtracciones.add(pA);
    }
    
    //metodo crea operario y añade dispositivo
    public void crearOperario(String nombre, double salario, String id, Dispositivo d){
         Operario o = new Operario();
         o.setNombre(nombre);
         o.setSalario(salario);
         o.setId(id);
         o.setDispositivo(d);
    }
    
}
