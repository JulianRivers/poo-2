/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.factory;

import model.DTO.CarroDTO;
import model.DTO.MotoDTO;
import model.DTO.VehiculoDTO;

/**
 *
 * @author Julian
 */
public class MotoFactory implements VehiculoFactory{

    @Override
    public VehiculoDTO crearVehiculo() throws Exception {
        VehiculoDTO veh = new MotoDTO();
        return veh;
    }
 
}
