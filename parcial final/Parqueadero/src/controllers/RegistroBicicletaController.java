package controllers;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ResourceBundle;
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

public class RegistroBicicletaController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Label lblRegistroVehiculo;

	@FXML
	private TextField txtCC;

	@FXML
	private ComboBox<String> cbTipo;

	@FXML
	private ComboBox<String> cbMarca;

	@FXML
	private Label lblRespuesta;

	@FXML
	void ingresar(ActionEvent event) throws Exception {
		try {
			Fachada.getInstance().ingresarVehiculo(cbMarca.getSelectionModel().getSelectedIndex() + 1, txtCC.getText(),
					cbTipo.getSelectionModel().getSelectedItem(), DataTransfer.getInstance().getVehiculo());
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
		cbMarca.getItems().addAll(Fachada.getInstance().listarMarcas());
		cbMarca.setValue("Kia");
		cbTipo.getItems().addAll(Fachada.getInstance().listarTipoBicicletas());
		cbTipo.setValue("Montañera");
	}

}
