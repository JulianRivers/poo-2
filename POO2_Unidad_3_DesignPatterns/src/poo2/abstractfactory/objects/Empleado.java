package poo2.abstractfactory.objects;

public class Empleado {

	private String nombres, apellidos;
	private int edad;
	
	
	public Empleado() {}
	
	public Empleado(String nombres, String apellidos, int edad) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.edad = edad;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}
