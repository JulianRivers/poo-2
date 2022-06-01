package poo2.abstractfactory.client;

import java.util.Random;

import poo2.abstractfactory.factories.EmpleadoEnSitioFactory;
import poo2.abstractfactory.factories.EmpleadoFactory;
import poo2.abstractfactory.factories.EmpleadoRemotoFactory;
import poo2.abstractfactory.factories.EmpleadoTercerizadoFactory;
import poo2.abstractfactory.objects.Empleado;

public class AppClient {

	public static void main(String[] args) {
		
		AppClient app = new AppClient();
		
		EmpleadoFactory factory = app.configureApplication();
		Empleado emp = factory.crearEmpleado();
		emp.setEdad(5);
		
		emp = factory.crearEmpleado();
		emp.setEdad(7);
		
		emp = factory.crearEmpleado();
		emp.setEdad(8);
		
	}
	
	private EmpleadoFactory configureApplication() {
		
		EmpleadoFactory factory = null;
		
		// Se simula la revisión de parámetros de configuracion
		int random = ((new Random()).nextInt()*10);
		
		if(random>2)
			factory = new EmpleadoEnSitioFactory();
		else if(random>6)
			factory = new EmpleadoRemotoFactory();
		else 
			factory = new EmpleadoTercerizadoFactory();
		
		return factory;
		
	}
	
}
