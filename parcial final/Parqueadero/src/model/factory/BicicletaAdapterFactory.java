/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.factory;

import model.DTO.BicicletaAdapterDTO;
import model.DTO.VehiculoDTO;

/**
 *
 * @author Julian
 */
public class BicicletaAdapterFactory implements VehiculoFactory{

    @Override
    public VehiculoDTO crearVehiculo() throws Exception {
        VehiculoDTO veh = new BicicletaAdapterDTO();
        return veh;
    }
    
}
