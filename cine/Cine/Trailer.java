package Cine;

public class Trailer
{
    protected int numeroTrailer;
    protected int segundosDuracion;
    protected ArrayList<Persona> editores = new ArrayList();

    public int getNumeroTrailer() {
        return numeroTrailer;
    }

    public void setNumeroTrailer(int numeroTrailer) {
        this.numeroTrailer = numeroTrailer;
    }

    public int getSegundosDuracion() {
        return segundosDuracion;
    }

    public void setSegundosDuracion(int segundosDuracion) {
        this.segundosDuracion = segundosDuracion;
    }

    public void agregarPersona(Persona p) {
        editores.add(p);
    }

}