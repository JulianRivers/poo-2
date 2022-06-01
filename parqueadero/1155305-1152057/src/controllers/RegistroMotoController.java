/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

package controllers;

import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Fachada;
import util.DataTransfer;
import util.UtilidadesVista;

public class RegistroMotoController {

    @FXML
    private ComboBox<String> cbCilindraje;

    @FXML
    private ComboBox<String> cbTipos;

    @FXML
    private ComboBox<String> cbMarca;

    @FXML
    private TextField txtPlaca;

    @FXML
    private Label lblRespuesta;

    @FXML
    private ComboBox<String> cbModelo;

    @FXML
    void ingresar(ActionEvent event) throws Exception {
        Fachada.getInstance().ingresarVehiculo(txtPlaca.getText(), cbMarca.getSelectionModel().getSelectedIndex()+1, 
                Integer.parseInt(cbCilindraje.getSelectionModel().getSelectedItem()), 
                Integer.parseInt(cbModelo.getSelectionModel().getSelectedItem()),
                cbTipos.getSelectionModel().getSelectedItem(), DataTransfer.getInstance().getVehiculo());
    }

    @FXML
    void volver(ActionEvent event) {
        try {
            Stage stage = UtilidadesVista.obtenerStage(event);
            stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/inicio.fxml"));
            Pane root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        } catch (Exception e) {
        }
    }

    @FXML
    void initialize() throws SQLException {
         cbTipos.getItems().clear();
        cbCilindraje.getItems().clear();
        cbModelo.getItems().clear();
        cbMarca.getItems().clear();
        cbTipos.getItems().addAll(Fachada.getInstance().listarTipoMotos());
        cbTipos.setValue("Urbana");
        cbCilindraje.getItems().addAll(Fachada.getInstance().listarCilindraje(DataTransfer.getInstance().getVehiculo()));
        cbCilindraje.setValue("200");
        cbModelo.getItems().addAll(Fachada.getInstance().listarModelo());
        cbModelo.setValue("1999");
        cbMarca.getItems().addAll(Fachada.getInstance().listarMarcas());
        cbMarca.setValue("Kia");
    }
}
