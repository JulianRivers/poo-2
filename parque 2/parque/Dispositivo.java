/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parque;

/**
 *
 * @author Julian
 */
class Dispositivo {

    static private int reparacionesRealizadas;
    private double valorarreglo;
    private boolean disponibilidad;
    private Vagon consultaVagon;
    private Vehiculo consultaVehiculo;
    private String direccion;
    private int posicion;

    public int getReparacionesrealizadas() {
        return reparacionesRealizadas;
    }

    public double getValorarreglo() {
        return valorarreglo;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setReparacionesrealizadas(int reparacionesRealizadas) {
        this.reparacionesRealizadas = reparacionesRealizadas;
    }

    public void setValorarreglo(double valorarreglo) {
        this.valorarreglo = valorarreglo;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Vagon getConsultaVagon() {
        return consultaVagon;
    }

    public void setConsultaVagon(Vagon consultaVagon) {
        this.consultaVagon = consultaVagon;
    }

    public Vehiculo getConsultaVehiculo() {
        return consultaVehiculo;
    }

    public void setConsultaVehiculo(Vehiculo consultaVehiculo) {
        this.consultaVehiculo = consultaVehiculo;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public static int getReparacionesRealizadas() {
        return reparacionesRealizadas;
    }

    public void contararreglos() {
        if(consultaVagon.isEstado() == true || consultaVehiculo.isEstado() == true){
            reparacionesRealizadas++;
        }

    }
}
