/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redSocial.controllers;

/**
 *
 * @author Julian
 */
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import redSocial.model.Fachada;
import redSocial.util.DataTransfer;
import redSocial.util.Utilidades;

public class LoginPageController {

    private Fachada fachada;

    @FXML
    private Label usuarioID;

    @FXML
    private TextField userTxt;

    @FXML
    private TextField passwordTxt;

    @FXML
    private ImageView loginImage;

    public LoginPageController() {
        fachada = Fachada.getInstance();
    }

    @FXML
    public void ingresar(ActionEvent event) {
        try {
            
            String nombreCompleto = fachada.validarCredenciales(userTxt.getText(), passwordTxt.getText()).getNombreCompleto();
            String email = fachada.validarCredenciales(userTxt.getText(), passwordTxt.getText()).getEmail();
            int edad = fachada.validarCredenciales(userTxt.getText(), passwordTxt.getText()).getEdad();
            String nick = fachada.validarCredenciales(userTxt.getText(), passwordTxt.getText()).getNick();
            String id = fachada.validarCredenciales(userTxt.getText(), passwordTxt.getText()).getId();
            // Enviar a la siguiente pantalla

            Stage stage = Utilidades.obtenerStage(event);
            stage.close();

            try {

                DataTransfer.getInstance().setNombreCompleto(nombreCompleto);
                DataTransfer.getInstance().setEmail(email);
                DataTransfer.getInstance().setEdad(edad);
                DataTransfer.getInstance().setNick(nick);
                DataTransfer.getInstance().setId(id);

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/redSocial/views/mainPage.fxml"));
                Pane root = loader.load();

                Scene scene = new Scene(root);
                stage.setScene(scene);

                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }
    }

    @FXML
    public void registrar(ActionEvent event) {
        try {
            Stage stage = Utilidades.obtenerStage(event);
            stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/redSocial/views/registro.fxml"));
            Pane root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        } catch (Exception e) {

        }
    }

    @FXML
    void initialize() {
        assert usuarioID != null : "fx:id=\"usuarioID\" was not injected: check your FXML file 'loginPage.fxml'.";
        assert userTxt != null : "fx:id=\"userTxt\" was not injected: check your FXML file 'loginPage.fxml'.";
        assert passwordTxt != null : "fx:id=\"passwordTxt\" was not injected: check your FXML file 'loginPage.fxml'.";
        assert loginImage != null : "fx:id=\"loginImage\" was not injected: check your FXML file 'loginPage.fxml'.";
        
    }

}
