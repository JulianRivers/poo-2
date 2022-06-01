package poo2.parqueadero.model.factory;

import poo2.parqueadero.model.dto.CarroDTO;
import poo2.parqueadero.model.dto.VehiculoDTO;

public class CarroVehiculoFactory implements VehiculoFactory {

	@Override
	public VehiculoDTO crearVehiculo() {
		CarroDTO dto = new CarroDTO();
		return dto;
	}

}
