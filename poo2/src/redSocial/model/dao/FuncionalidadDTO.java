package redSocial.model.dao;

public class FuncionalidadDTO {

	private String nombre, url;
	
	public FuncionalidadDTO() {
	}
	
	public FuncionalidadDTO(String nombre, String url) {
		this.nombre = nombre;
		this.url = url;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
