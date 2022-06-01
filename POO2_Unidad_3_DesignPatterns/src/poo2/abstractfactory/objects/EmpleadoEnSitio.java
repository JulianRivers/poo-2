package poo2.abstractfactory.objects;

public class EmpleadoEnSitio extends Empleado {

	private String puestoAsignado;
	
	public EmpleadoEnSitio() {
		System.out.println("Se instancia EmpleadoEnSitio");
	}

	public String getPuestoAsignado() {
		return puestoAsignado;
	}

	public void setPuestoAsignado(String puestoAsignado) {
		this.puestoAsignado = puestoAsignado;
	}
	
	
	
}
