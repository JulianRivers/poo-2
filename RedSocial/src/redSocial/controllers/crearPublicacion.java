package redSocial.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import redSocial.model.Fachada;
import redSocial.util.DataTransfer;
import redSocial.util.Utilidades;

public class crearPublicacion {
    
    private Fachada fachada;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea mensajeTxt;

    @FXML
    private TextField cuposTxt;

    @FXML
    private TextField urlTxt;

    @FXML
    private ListView<String> amigos;

    @FXML
    private RadioButton publicacion;

    @FXML
    private RadioButton evento;

    @FXML
    private RadioButton enlace;

    public crearPublicacion() {
        this.fachada = Fachada.getInstance();
    }

    @FXML
    void crearPublicacion(ActionEvent event) {
        if (evento.isSelected()) {
            fachada.crearPublicacion(mensajeTxt.getText() , DataTransfer.getInstance().getNick(), Integer.parseInt(cuposTxt.getText()));
        } else if (enlace.isSelected()) {
            fachada.crearPublicacion(mensajeTxt.getText(), DataTransfer.getInstance().getNick(), urlTxt.getText());
        } else {
            fachada.crearPublicacion(mensajeTxt.getText(), DataTransfer.getInstance().getNick());
        }
        try {
            Stage stage = Utilidades.obtenerStage(event);
            stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/redSocial/views/publicaciones.fxml"));
            Pane root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        } catch (Exception e) {
        }
    }

    @FXML
    void setEnlace(ActionEvent event) {
        evento.setSelected(false);
        publicacion.setSelected(false);
        urlTxt.setDisable(false);
        cuposTxt.setDisable(true);
    }

    @FXML
    void setEvento(ActionEvent event) {
        publicacion.setSelected(false);
        enlace.setSelected(false);
        urlTxt.setDisable(true);
        cuposTxt.setDisable(false);
    }

    @FXML
    void setPublicacion(ActionEvent event) {
        evento.setSelected(false);
        enlace.setSelected(false);
        urlTxt.setDisable(true);
        cuposTxt.setDisable(true);
    }

    @FXML
    void volver(ActionEvent event) {
        try {
            Stage stage = Utilidades.obtenerStage(event);
            stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/redSocial/views/publicaciones.fxml"));
            Pane root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        } catch (Exception e) {
        }
    }

    @FXML
    void initialize() {
        assert mensajeTxt != null : "fx:id=\"mensajeTxt\" was not injected: check your FXML file 'crearPublicacion.fxml'.";
        assert cuposTxt != null : "fx:id=\"cuposTxt\" was not injected: check your FXML file 'crearPublicacion.fxml'.";
        assert urlTxt != null : "fx:id=\"urlTxt\" was not injected: check your FXML file 'crearPublicacion.fxml'.";
        assert amigos != null : "fx:id=\"amigos\" was not injected: check your FXML file 'crearPublicacion.fxml'.";
        cuposTxt.setDisable(true);
        urlTxt.setDisable(true);
    }
}
