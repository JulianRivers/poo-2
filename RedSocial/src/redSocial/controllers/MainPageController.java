package redSocial.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import redSocial.model.Fachada;
import redSocial.util.DataTransfer;
import redSocial.util.Utilidades;

public class MainPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView profileImage;

    @FXML
    private ListView<String> listViewUsuario;

    @FXML
    private ListView<String> listViewAmigos;

    @FXML
    private ListView<String> listViewGrupos;

    @FXML
    private Label profileName;

    @FXML
    private ImageView logoImage;


    @FXML
    void abrirAmigos(ActionEvent event) {
        try {
            Stage stage = Utilidades.obtenerStage(event);
            stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/redSocial/views/amigos.fxml"));
            Pane root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        } catch (Exception e) {
        }
    }

    @FXML
    void abrirGrupos(ActionEvent event) {
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
    void abrirInicio(ActionEvent event) {
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
    void salir(ActionEvent event) {
        
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
    void initialize() {
        assert profileImage != null : "fx:id=\"profileImage\" was not injected: check your FXML file 'mainPage.fxml'.";
        assert listViewUsuario != null : "fx:id=\"listViewUsuario\" was not injected: check your FXML file 'mainPage.fxml'.";
        assert listViewAmigos != null : "fx:id=\"listViewAmigos\" was not injected: check your FXML file 'mainPage.fxml'.";
        assert listViewGrupos != null : "fx:id=\"listViewGrupos\" was not injected: check your FXML file 'mainPage.fxml'.";
        assert profileName != null : "fx:id=\"profileName\" was not injected: check your FXML file 'mainPage.fxml'.";
        assert logoImage != null : "fx:id=\"logoImage\" was not injected: check your FXML file 'mainPage.fxml'.";
        profileName.setText(DataTransfer.getInstance().getNombreCompleto());
        listViewUsuario.getItems().add("Nick: " + DataTransfer.getInstance().getNick());
        listViewUsuario.getItems().add("Edad: " + DataTransfer.getInstance().getEdad());
        listViewUsuario.getItems().add("Email: " + DataTransfer.getInstance().getEmail());
        listViewUsuario.getItems().add("Id: " + DataTransfer.getInstance().getId());
       

    }
}
