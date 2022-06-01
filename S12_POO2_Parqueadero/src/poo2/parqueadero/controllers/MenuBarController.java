package poo2.parqueadero.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MenuBarController {

	@FXML 
	private MenuBar myMenuBar;
	
	@FXML
	public void handleIngresarCarroMenu(ActionEvent event) {
		try {
			GridPane root = (GridPane) FXMLLoader
					.load(getClass().getResource("/poo2/parqueadero/views/IngresarCarroView.fxml"));

			Stage stage = (Stage) myMenuBar.getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void handleIngresarMotoMenu(ActionEvent event) {
		try {
			GridPane root = (GridPane) FXMLLoader
					.load(getClass().getResource("/poo2/parqueadero/views/IngresarMotoView.fxml"));

			Stage stage = (Stage) myMenuBar.getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@FXML
	public void handleInicioMenu(ActionEvent event) {
		try {
			GridPane root = (GridPane) FXMLLoader
					.load(getClass().getResource("/poo2/parqueadero/views/PrincipalView.fxml"));

			Stage stage = (Stage) myMenuBar.getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void handleListarMenu(ActionEvent event) {
				
	}
	
}
