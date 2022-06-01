package redSocial.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import redSocial.model.Fachada;
import redSocial.model.dao.EnlaceDTO;
import redSocial.model.dao.EventoDTO;
import redSocial.model.dao.PublicacionDTO;
import redSocial.model.dao.UsuarioDTO;
import redSocial.util.DataTransfer;
import redSocial.util.Utilidades;

public class PublicacionesController {

    private Fachada fachada;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> publicacionesAmigos;

    @FXML
    private TextArea publicaciones;

    public PublicacionesController() {
        fachada = Fachada.getInstance();
    }

    @FXML
    void crearPublicacion(ActionEvent event) {
        try {
            Stage stage = Utilidades.obtenerStage(event);
            stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/redSocial/views/crearPublicacion.fxml"));
            Pane root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
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
            System.out.println(e.fillInStackTrace());
        }

    }

    @FXML
    void verPublicacion(ActionEvent event) {
        refrescarPublicaciones();
    }

    @FXML
    void initialize() {
        assert publicacionesAmigos != null : "fx:id=\"publicacionesAmigos\" was not injected: check your FXML file 'publicaciones.fxml'.";
        assert publicaciones != null : "fx:id=\"publicaciones\" was not injected: check your FXML file 'publicaciones.fxml'.";

        ArrayList<UsuarioDTO> listaUsuarios = fachada.listarUsuarios();

        if (listaUsuarios != null) {
            publicacionesAmigos.getItems().clear();

            for (UsuarioDTO dto : listaUsuarios) {
                publicacionesAmigos.getItems().add(dto.getNick());
            }

        }
    }

    private void refrescarPublicaciones() {

        publicaciones.clear();

        ArrayList<PublicacionDTO> listaPublicaciones = fachada.listarPublicacionesUsuario(publicacionesAmigos.getSelectionModel().getSelectedItem());
        if (listaPublicaciones != null) {
            for (PublicacionDTO dto : listaPublicaciones) {
                publicaciones.appendText(dto.getTexto());
                publicaciones.appendText("\n");
                
                if (dto instanceof EventoDTO) {
                    publicaciones.appendText("Numero de cupos: " + String.valueOf(((EventoDTO) dto).getNumCupos()));
                } else if (dto instanceof EnlaceDTO) {
                    publicaciones.appendText("Url: " + ((EnlaceDTO) dto).getUrl());
                }

                publicaciones.appendText("\n");

                String fecha = dto.getFechaPublicacion().get(Calendar.DATE) + "/"
                        + (dto.getFechaPublicacion().get(Calendar.MONTH) + 1) + "/"
                        + dto.getFechaPublicacion().get(Calendar.YEAR);

                publicaciones.appendText(fecha);
                publicaciones.appendText("\n\n");
            }

        } else {
            publicaciones.setText("No hay publicaciones");
        }
    }
}
