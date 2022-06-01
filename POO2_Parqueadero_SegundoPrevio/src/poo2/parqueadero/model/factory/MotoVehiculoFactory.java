package poo2.parqueadero.model.factory;

import poo2.parqueadero.model.dto.MotoDTO;
import poo2.parqueadero.model.dto.VehiculoDTO;

public class MotoVehiculoFactory implements VehiculoFactory{

	@Override
	public VehiculoDTO crearVehiculo() {
		MotoDTO dto = new MotoDTO();
		return dto;
	}

}
