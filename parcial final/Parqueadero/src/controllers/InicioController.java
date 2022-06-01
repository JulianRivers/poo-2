package controllers;

import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import model.Fachada;
import util.DataTransfer;
import util.UtilidadesVista;

public class InicioController {

    private Fachada parqueadero;
    
    @FXML
    private ListView<String> lvVehiculos;

    @FXML
    private Label lblRespuesta;

    
    public InicioController() throws RemoteException {
    	try {
    		parqueadero = Fachada.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }
    
    @FXML
    void ingresar(ActionEvent event) {
        if (DataTransfer.getInstance().getVehiculo() > 0) {
            try {
                String vehiculo = UtilidadesVista.traducirTipoVehiculo(DataTransfer.getInstance().getVehiculo());
                Stage stage = UtilidadesVista.obtenerStage(event);
                stage.close();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/registro" + vehiculo + ".fxml"));
                Pane root = loader.load();

                Scene scene = new Scene(root);

                stage.setScene(scene);

                stage.show();
            } catch (IOException e) {
                System.out.println("No se ha devuelto con exito");
                System.out.println(e.fillInStackTrace());
            }
        } else {
            lblRespuesta.setText("Seleccione un vehiculo");
        }
    }

    @FXML
    void retirar(ActionEvent event) throws SQLException {
        
    }

    @FXML
    void abrirAgenteEuropeo(ActionEvent event) {
        try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/EuropeanAgent.fxml"));

            Stage stage = new Stage();

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void abrirGestorSuscriptores(ActionEvent event) {
    	try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/gestorSuscripciones.fxml"));

            Stage stage = new Stage();

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void setCarro(ActionEvent event) {
        DataTransfer.getInstance().setVehiculo((byte) 1);
    }

    @FXML
    void setMoto(ActionEvent event) {
        DataTransfer.getInstance().setVehiculo((byte) 2);
    }

    @FXML
    void setBicicleta(ActionEvent event) {
        DataTransfer.getInstance().setVehiculo((byte) 3);
    }

    @FXML
    void initialize() throws SQLException, RemoteException {
        lvVehiculos.getItems().addAll(Fachada.getInstance().listarVehiculos());
    }

}
