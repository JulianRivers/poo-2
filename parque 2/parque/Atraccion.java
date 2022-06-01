
package parque;

import java.util.ArrayList;

/**
 *
 * @author Julian
 */
public class Atraccion {

    protected String ubicacion;
    protected boolean estado;
    protected int cantidadPasajero;
    protected int cantidadVueltas;
    protected Torniquete torniqueteEntrada;
    protected Torniquete torniqueteSalida;

    public Atraccion() {
    }

    public Atraccion(String ubicacion) {
        this.ubicacion = ubicacion;
        this.estado=true;
        this.cantidadPasajero=0;
        this.cantidadVueltas=0;
    }

    
    public String getUbicacion() {
        return ubicacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public int getCantidadpasajero() {
        return cantidadPasajero;
    }

    public int getCantidadVueltas() {
        return cantidadVueltas;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setCantidadpasajero(int cantidadPasajero) {
        this.cantidadPasajero = cantidadPasajero;
    }

    public void setCantidadVueltas(int cantidadVueltas) {
        this.cantidadVueltas = cantidadVueltas;
    }

    public int getCantidadPasajero() {
        return cantidadPasajero;
    }

    public void setCantidadPasajero(int cantidadPasajero) {
        this.cantidadPasajero = cantidadPasajero;
    }

    public Torniquete getTorniqueteEntrada() {
        return torniqueteEntrada;
    }

    public void setTorniqueteEntrada(Torniquete torniqueteEntrada) {
        this.torniqueteEntrada = torniqueteEntrada;
    }

    public Torniquete getTorniqueteSalida() {
        return torniqueteSalida;
    }

    public void setTorniqueteSalida(Torniquete torniqueteSalida) {
        this.torniqueteSalida = torniqueteSalida;
    }
    
    public void crearParque(String ubicacionReal, ArrayList atracciones){
        ParqueAtracciones pA = new ParqueAtracciones();
        
        pA.setUbicacionReal(ubicacionReal);
        pA.setAtracciones(atracciones);
    }
}
