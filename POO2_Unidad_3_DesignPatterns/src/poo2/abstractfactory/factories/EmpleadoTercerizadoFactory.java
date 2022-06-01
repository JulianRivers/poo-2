package poo2.abstractfactory.factories;

import poo2.abstractfactory.objects.Empleado;
import poo2.abstractfactory.objects.EmpleadoTercerizado;

public class EmpleadoTercerizadoFactory implements EmpleadoFactory {

	@Override
	public Empleado crearEmpleado() {
		Empleado emp = new EmpleadoTercerizado();
		
		return emp;
	}

	
	
}
