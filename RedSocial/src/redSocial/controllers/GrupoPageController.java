package redSocial.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import redSocial.model.Fachada;
import redSocial.model.dao.GrupoDTO;
import redSocial.util.DataTransfer;
import redSocial.util.Utilidades;

public class GrupoPageController {

    private Fachada fachada;

    public GrupoPageController() {
        this.fachada = Fachada.getInstance();
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> tepuedesUnirListview;

    @FXML
    private ListView<String> gruposPertenecesListView;

    @FXML
    private Button unirseButton;

    @FXML
    private Button crearGrupoButton;

    @FXML
    private ListView<String> informacionListView;

    @FXML
    private ListView<String> integrantesListView;

    @FXML
    private Button volverButton;

    @FXML
    void crearGrupo(ActionEvent event) {
        try {
            Stage stage = Utilidades.obtenerStage(event);
            stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/redSocial/views/CreateGroups.fxml"));
            Pane root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        } catch (Exception e) {
            System.out.println("No se ha devuelto con exito");
            System.out.println(e.fillInStackTrace());
        }
    }

    @FXML
    void unirse(ActionEvent event) {
        try {
            fachada.unirseGrupo(tepuedesUnirListview.getSelectionModel().getSelectedItem());
            refrescarGrupos();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    @FXML
    void volver(ActionEvent event) {
        try {
            Stage stage = Utilidades.obtenerStage(event);
            stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/redSocial/views/mainPage.fxml"));
            Pane root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        } catch (Exception e) {
            System.out.println("No se ha devuelto con exito");
            System.out.println(e.fillInStackTrace());
        }
    }

    @FXML
    void initialize() {
        assert tepuedesUnirListview != null : "fx:id=\"tepuedesUnirListview\" was not injected: check your FXML file 'grupoPage.fxml'.";
        assert gruposPertenecesListView != null : "fx:id=\"gruposPertenecesListView\" was not injected: check your FXML file 'grupoPage.fxml'.";
        assert unirseButton != null : "fx:id=\"unirseButton\" was not injected: check your FXML file 'grupoPage.fxml'.";
        assert crearGrupoButton != null : "fx:id=\"crearGrupoButton\" was not injected: check your FXML file 'grupoPage.fxml'.";
        assert informacionListView != null : "fx:id=\"informacionListView\" was not injected: check your FXML file 'grupoPage.fxml'.";
        assert integrantesListView != null : "fx:id=\"integrantesListView\" was not injected: check your FXML file 'grupoPage.fxml'.";
        assert volverButton != null : "fx:id=\"volverButton\" was not injected: check your FXML file 'grupoPage.fxml'.";
        refrescarGrupos();
        try {
            for (int i = 0; i < DataTransfer.getInstance().getGrupos().size(); i++) {
                if (DataTransfer.getInstance().getGrupos().get(i) != null) {
                    tepuedesUnirListview.getItems().add(DataTransfer.getInstance().getGrupos().get(i).getNombre());
                }
            }
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }

//        gruposPertenecesListView.getItems().clear();
//        informacionListView.getItems().clear();
    }

    private void refrescarGrupos() {
//        gruposPertenecesListView.getItems().clear();
//        if (DataTransfer.getInstance().getGruposPerteneces() != null) {
//            for (int i = 0; i < 10; i++) {
//                gruposPertenecesListView.getItems().add(DataTransfer.getInstance().getGruposPerteneces().get(i).getNombre());
//            }
//        }
    }
}
