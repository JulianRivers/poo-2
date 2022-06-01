package poo2.abstractfactory.factories;

import poo2.abstractfactory.objects.Empleado;
import poo2.abstractfactory.objects.EmpleadoRemoto;

public class EmpleadoRemotoFactory implements EmpleadoFactory {

	@Override
	public Empleado crearEmpleado() {
		EmpleadoRemoto emp = new EmpleadoRemoto();
		
		return emp;
	}

}
