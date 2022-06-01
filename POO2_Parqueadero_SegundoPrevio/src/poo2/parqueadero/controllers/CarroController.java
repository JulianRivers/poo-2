package poo2.parqueadero.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import poo2.parqueadero.model.fachada.Parqueadero;

public class CarroController implements Initializable {

	@FXML private TextField txtPlaca;
	@FXML private ComboBox<String> cmbMarcas;
	
	private ObservableList<String> listMarcasCombo;
	private Parqueadero parqueadero;
	
	public CarroController() {
		parqueadero = Parqueadero.getInstance();
		listMarcasCombo = FXCollections.observableArrayList();
	}
	
	@FXML
	public void handleRegistrarEntrada(ActionEvent ev) {
		String placa = txtPlaca.getText();
		String marca = cmbMarcas.getValue();
		
		parqueadero.registrarEntradaVehiculo(placa, marca, null, null, 'c');
		
		txtPlaca.clear();
		cmbMarcas.getSelectionModel().clearSelection();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		cmbMarcas.setItems(listMarcasCombo);		
		
		ArrayList<String> listaMarcas = parqueadero.listarMarcas();		
		listMarcasCombo.addAll(listaMarcas);	
		
	}
	
}
