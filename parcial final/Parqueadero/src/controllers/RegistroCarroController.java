/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import java.io.IOException;
import java.rmi.RemoteException;
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

public class RegistroCarroController {

    @FXML
    private ComboBox<String> cbCilindraje;

    @FXML
    private ComboBox<String> cbPuertas;

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
    	try {
    		Fachada.getInstance().ingresarVehiculo(
    				txtPlaca.getText(), 
    				cbMarca.getSelectionModel().getSelectedIndex()+1, 
                    Integer.parseInt((String) cbModelo.getSelectionModel().getSelectedItem()) , 
                    cbCilindraje.getSelectionModel().getSelectedIndex()+1, 
                    Integer.parseInt((String) cbPuertas.getSelectionModel().getSelectedItem()), 
                    DataTransfer.getInstance().getVehiculo());
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
    void volver(ActionEvent event) {
        try {
            Stage stage = UtilidadesVista.obtenerStage(event);
            stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/inicio.fxml"));
            Pane root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        } catch (IOException e) {
        }
    }
    
    @FXML
    void initialize() throws SQLException, RemoteException {
        cbPuertas.getItems().clear();
        cbCilindraje.getItems().clear();
        cbModelo.getItems().clear();
        cbMarca.getItems().clear();
        cbPuertas.getItems().addAll(Fachada.getInstance().listarNoPuertas());
        cbPuertas.setValue("2");
        cbCilindraje.getItems().addAll(Fachada.getInstance().listarCilindraje(DataTransfer.getInstance().getVehiculo()));
        cbCilindraje.setValue("1000");
        cbModelo.getItems().addAll(Fachada.getInstance().listarModelo());
        cbModelo.setValue("1999");
        cbMarca.getItems().addAll(Fachada.getInstance().listarMarcas());
        cbMarca.setValue("Kia");
        
    }

}
