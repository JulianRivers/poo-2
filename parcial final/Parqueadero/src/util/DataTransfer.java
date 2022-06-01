/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Julian
 */
public class DataTransfer {

    private static DataTransfer instance;
    private byte vehiculo;

    private DataTransfer() {
    }

    public static DataTransfer getInstance() {
        if (instance == null) {
            instance = new DataTransfer();
        }
        return instance;
    }

    public byte getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(byte vehiculo) {
        this.vehiculo = vehiculo;
    }


}
