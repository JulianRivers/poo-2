package poo2.abstractfactory.objects;

public class EmpleadoTercerizado extends Empleado{

	private String companiaContratada;

	public EmpleadoTercerizado() {
		System.out.println("Se creó EmpleadoTercerizado");
	}
	
	public String getCompaniaContratada() {
		return companiaContratada;
	}

	public void setCompaniaContratada(String companiaContratada) {
		this.companiaContratada = companiaContratada;
	}
	
	
	
}
