package poo2.parqueadero.model.factory;

import poo2.parqueadero.model.dto.BicicletaDTOAdapter;
import poo2.parqueadero.model.dto.VehiculoDTO;

public class BicicletaAdapterVehiculoFactory implements VehiculoFactory {

	@Override
	public VehiculoDTO crearVehiculo() {
		BicicletaDTOAdapter dto = new BicicletaDTOAdapter();
		return dto;
	}

}
