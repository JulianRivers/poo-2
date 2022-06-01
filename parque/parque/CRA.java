package parque;

import java.util.ArrayList;

public class CRA {

    private ArrayList<Dispositivo> dispositivos = new ArrayList();
    private ArrayList<MontaniaRusa> montanias = new ArrayList();
    private ArrayList<Noria> norias = new ArrayList();

    public ArrayList<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public ArrayList<MontaniaRusa> getMontanias() {
        return montanias;
    }

    public void setMontanias(ArrayList<MontaniaRusa> montanias) {
        this.montanias = montanias;
    }

    public ArrayList<Noria> getNorias() {
        return norias;
    }

    public void setNorias(ArrayList<Noria> norias) {
        this.norias = norias;
    }

    public void buscarOperarioParaMontania() {

        for (int i = 0; i < dispositivos.size(); i++) {
            if (dispositivos.get(i).isDisponibilidad() == true) {
                dispositivos.get(i).setDireccion(montanias.get(i).getUbicacion());
                dispositivos.get(i).setPosicion(montanias.get(i).verificacionVagones());
                dispositivos.get(i).setDisponibilidad(false);
            }
        }
    }

    public void buscarOperarioParaNoria() {

        for (int i = 0; i < dispositivos.size(); i++) {
            if (dispositivos.get(i).isDisponibilidad() == true) {
                dispositivos.get(i).setDireccion(norias.get(i).getUbicacion());
                dispositivos.get(i).setPosicion(norias.get(i).verificacionVehiculos());
                dispositivos.get(i).setDisponibilidad(false);
            }
        }
    }
}
