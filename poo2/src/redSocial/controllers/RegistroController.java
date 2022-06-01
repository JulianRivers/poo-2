package redSocial.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import redSocial.model.Fachada;
import redSocial.model.dao.UsuarioDAO;
import redSocial.util.Utilidades;

public class RegistroController {

     private Fachada fachada;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nombreTxt;

    @FXML
    private TextField apellidoTxt;

    @FXML
    private TextField edadTxt;

    @FXML
    private TextField idTxt;

    @FXML
    private TextField correoTxt;

    @FXML
    private TextField passwordTxt;

    public RegistroController() {
        fachada = Fachada.getInstance();
    }
    @FXML
    void cancelar(ActionEvent event) {
        try {
            Stage stage = Utilidades.obtenerStage(event);
            stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/redSocial/views/loginPage.fxml"));
            Pane root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        } catch (Exception e) {

        }
    }

    @FXML
    void registrar(ActionEvent event) {
        try{
            fachada.crearUsuario(nombreTxt.getText(), apellidoTxt.getText(), Integer.parseInt(edadTxt.getText()), correoTxt.getText(),idTxt.getText(),passwordTxt.getText());
        try {
            Stage stage = Utilidades.obtenerStage(event);
            stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/redSocial/views/loginPage.fxml"));
            Pane root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        } catch (Exception e) {}
        }catch (Exception e) {
            System.out.println("usuario no registrado");
        }
    }

    @FXML
    void initialize() {
        assert nombreTxt != null : "fx:id=\"nombreTxt\" was not injected: check your FXML file 'registro.fxml'.";
        assert apellidoTxt != null : "fx:id=\"apellidoTxt\" was not injected: check your FXML file 'registro.fxml'.";
        assert edadTxt != null : "fx:id=\"edadTxt\" was not injected: check your FXML file 'registro.fxml'.";
        assert idTxt != null : "fx:id=\"idTxt\" was not injected: check your FXML file 'registro.fxml'.";
        assert correoTxt != null : "fx:id=\"correoTxt\" was not injected: check your FXML file 'registro.fxml'.";
        assert passwordTxt != null : "fx:id=\"passwordTxt\" was not injected: check your FXML file 'registro.fxml'.";

    }
}
