package Cine;

import java.util.Date;

public class Pelicula {

    private String titulo;
    private String sinopsis;
    private String genero;
    private String pais;
    private Productor productor;

    public Pelicula() {
    }

    public Pelicula(String titulo, String sinopsis, String genero, String pais) {
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.genero = genero;
        this.pais = pais;
    }

    public Pelicula(String titulo, String sinopsis, String genero, String pais, Productor productor) {
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.genero = genero;
        this.pais = pais;
        this.productor = productor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void crearActor(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, double salario ) {
        Actor a = new Actor(nombre, apellido, fechaNacimiento, nacionalidad, salario);
    }

    public void crearTrailer(int numeroTrailer, int segundosDuracion) {
        Trailer t = new Trailer();

        t.setNumeroTrailer(numeroTrailer);
        t.setSegundosDuracion(segundosDuracion);
    }
    public void añadirProductor(Productor p){
        productor = p;
    }
    public void crearDirector(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, double salario ){
        Director d = new Director(nombre, apellido, fechaNacimiento, nacionalidad, salario);
    }
    public void crearGuionista(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, double salario ){
        Guionista g = new Guionista(nombre, apellido, fechaNacimiento, nacionalidad, salario);
    }
}
