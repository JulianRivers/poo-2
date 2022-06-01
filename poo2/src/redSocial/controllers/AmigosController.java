package redSocial.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import redSocial.model.Fachada;
import redSocial.model.dao.UsuarioDAO;
import redSocial.model.dao.UsuarioDTO;
import redSocial.util.DataTransfer;
import redSocial.util.Utilidades;

public class AmigosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label profileName;

    @FXML
    private TextField amigoTxt;

    @FXML
    private Label respuesta;

    @FXML
    private ListView<String> amigosListView;

    @FXML
    void agregar(ActionEvent event) {
        if (!Fachada.getInstance().validarAmigo(amigoTxt.getText()) && !DataTransfer.getInstance().getNick().equals(amigoTxt.getText())) {
            if (Fachada.getInstance().addAmigos(amigoTxt.getText()) != null) {
                amigosListView.getItems().add(Fachada.getInstance().addAmigos(amigoTxt.getText()).getNombreCompleto());
                respuesta.setText("");
            } else {
                respuesta.setText("Este usuario no existe.");
            }
        } else {
            respuesta.setText("Ya es tu amigo o eres tú mismo.");
        }

    }

    @FXML
    void volver(ActionEvent event) {
        try {
            Stage stage = Utilidades.obtenerStage(event);
            stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/redSocial/views/MainPage.fxml"));
            Pane root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        } catch (Exception e) {
        }
    }

    @FXML
    void initialize() {
        assert profileName != null : "fx:id=\"profileName\" was not injected: check your FXML file 'amigos.fxml'.";
        assert amigoTxt != null : "fx:id=\"amigoTxt\" was not injected: check your FXML file 'amigos.fxml'.";
        assert respuesta != null : "fx:id=\"respuesta\" was not injected: check your FXML file 'amigos.fxml'.";
        profileName.setText(DataTransfer.getInstance().getNombreCompleto());
        try {
            for (int i = 0; i < DataTransfer.getInstance().getAmigos().size(); i++) {
                if (DataTransfer.getInstance().getAmigos().get(i) != null) {
                    amigosListView.getItems().add(DataTransfer.getInstance().getAmigos().get(i).getNombreCompleto());
                }
            }
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }
}
