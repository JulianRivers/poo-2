package poo2.parqueadero.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PrincipalController {
	
	
	
	@FXML
	public void handleAgente(ActionEvent ev) {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader
					.load(getClass().getResource("/poo2/parqueadero/views/ExternalAgent.fxml"));

			Stage stage = new Stage();
			
			Scene scene = new Scene(root);
			
			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
