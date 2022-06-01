package poo2.parqueadero.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import poo2.parqueadero.model.fachada.Parqueadero;

public class CentralReporteController implements ControllerInterface{

	@FXML private TextField txtCarros;
	@FXML private TextField txtMotos;
	@FXML private TextField txtBicicletas;
	@FXML private TextField txtVehiculos;
	
	private Parqueadero parqueadero;
	
	
	public CentralReporteController() {
		parqueadero = Parqueadero.getInstance();
	}
	
	public void setTextToTxtCarros(String text) {
		txtCarros.setText(text);		
	}
	
	public void setTextToTxtMotos(String text) {
		txtMotos.setText(text);		
	}
	
	@FXML
	public void handleSuscribirse(ActionEvent ev) {
		// Obtener instancia de la fachada (publicador)
		// Suscribirse
		
		parqueadero.addController(this);
		System.out.println("Suscribiendo... ");
	}

	@Override
	public void update(String msg) {
		System.out.println("Imprime controlador suscriptor: "+msg);
		
		if(msg.equals("carro")) {
			String cantidad = txtCarros.getText();
			if(cantidad.isBlank())
				cantidad = "0";
			
			int cant = Integer.parseInt(cantidad);
			
			txtCarros.setText(""+(cant+1));
		}
		
	}

}
