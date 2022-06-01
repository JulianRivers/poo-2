package poo2.abstractfactory.objects;

public class EmpleadoRemoto extends Empleado {

	private String usuarioZoom;
	
	public EmpleadoRemoto() {
		System.out.println("Se instancia EmpleadoRemoto");
	}

	public String getUsuarioZoom() {
		return usuarioZoom;
	}

	public void setUsuarioZoom(String usuarioZoom) {
		this.usuarioZoom = usuarioZoom;
	}
	
	
	
}
