package util;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class UtilidadesVista {

    public static Stage obtenerStage(ActionEvent event) {
        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        return stage;
    }

    public static String traducirTipoVehiculo(byte vehiculo) {
        String tipoVehiculo = null;
        switch (vehiculo) {
            case 1:
                tipoVehiculo="Carro";
                break;
            case 2:
                tipoVehiculo="Moto";
                break;
            case 3:
                tipoVehiculo="Bicicleta";
                break;
            default:
                throw new AssertionError();
        }
        return tipoVehiculo;
    }

}
