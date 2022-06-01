package controllers;

import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import model.Fachada;
import util.DataTransfer;
import util.UtilidadesVista;

public class InicioController {

    @FXML
    private ListView<String> lvVehiculos;

    @FXML
    private Label lblRespuesta;

    @FXML
    void ingresar(ActionEvent event) {
        if(DataTransfer.getInstance().getVehiculo() > 0){
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
        }else{
            lblRespuesta.setText("Seleccione un vehiculo");
        }
    }

    @FXML
    void retirar(ActionEvent event) throws SQLException {
        String placa = lvVehiculos.getSelectionModel().getSelectedItem().replaceAll(" ", "").substring(6, 12);
        String tipoVehiculo = lvVehiculos.getSelectionModel().getSelectedItem().replaceAll(" ", "").substring(40, 44);
        lblRespuesta.setText(tipoVehiculo);

        switch (tipoVehiculo) {
            case "carr":
                lvVehiculos.getItems().clear();

                lvVehiculos.getItems().addAll(Fachada.getInstance().listarVehiculos());
                break;
            case "moto":
                lvVehiculos.getItems().clear();

                lvVehiculos.getItems().addAll(Fachada.getInstance().listarVehiculos());
                break;
            default:
                lvVehiculos.getItems().addAll(Fachada.getInstance().listarVehiculos());
                throw new AssertionError();
        }
    }

    @FXML
    void abrirAgenteExterno(ActionEvent event) {
        try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/ExternalAgent.fxml"));

            Stage stage = new Stage();

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
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
    void initialize() throws SQLException {

        lvVehiculos.getItems().addAll(Fachada.getInstance().listarVehiculos());
        Fachada.getInstance().addController(ControllersPool.getInstance().getController("CentralReportesEuropea"));
        Fachada.getInstance().addController(ControllersPool.getInstance().getController("CentralReportesAmericano"));
    }

}
