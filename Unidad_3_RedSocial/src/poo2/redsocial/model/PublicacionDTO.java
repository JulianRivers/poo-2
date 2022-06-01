package poo2.redsocial.model;

import java.util.Calendar;

public class PublicacionDTO {
	
	private long id;
	private String texto;
	private Calendar fechaPublicacion;
	private String usuario;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Calendar getFechaPublicacion() {
		return fechaPublicacion;
	}
	public void setFechaPublicacion(Calendar fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
