package redSocial.controllers;

import java.io.IOException;
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
import redSocial.util.Utilidades;

public class CreateGroupsController {

    private Fachada fachada;

    public CreateGroupsController() {
        this.fachada = Fachada.getInstance();
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nombreGrupoTxt;

    @FXML
    private TextField descripcionTxt;

    @FXML
    private TextField tipoTxt;

    @FXML
    void crearGrupo(ActionEvent event) {
        try {
            fachada.crearGrupo(nombreGrupoTxt.getText(), descripcionTxt.getText(), tipoTxt.getText());
            
            try {
                Stage stage = Utilidades.obtenerStage(event);
                stage.close();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/redSocial/views/grupoPage.fxml"));
                Pane root = loader.load();

                Scene scene = new Scene(root);
                stage.setScene(scene);

                stage.show();
            } catch (Exception e) {
                System.out.println("No se ha devuelto con exito");
            }
        } catch (Exception e) {
            
        }
    }

    @FXML
    void volver(ActionEvent event) {
        try {
            Stage stage = Utilidades.obtenerStage(event);
            stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/redSocial/views/grupoPage.fxml"));
            Pane root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        } catch (Exception e) {
        }
    }

    @FXML
    void initialize() {
        assert nombreGrupoTxt != null : "fx:id=\"nombreGrupoTxt\" was not injected: check your FXML file 'CreateGroups.fxml'.";
        assert descripcionTxt != null : "fx:id=\"descripcionTxt\" was not injected: check your FXML file 'CreateGroups.fxml'.";
        assert tipoTxt != null : "fx:id=\"tipoTxt\" was not injected: check your FXML file 'CreateGroups.fxml'.";

    }
}
