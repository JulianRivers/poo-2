package controllers;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Fachada;
import model.DAO.ServidorDAO;

public class CentralReporteController extends UnicastRemoteObject implements ControllerInterface {

	@FXML
	private TextField txtCarros;

	@FXML
	private TextField txtMotos;

	@FXML
	private TextField txtBicicletas;

	@FXML
	private TextField txtVehiculos;

	private ControllerInterface servidorObj;
	private ServidorDAO dao;

	public CentralReporteController() throws RemoteException{
		try {
			servidorObj = Fachada.getInstance().EstablecerConexion();
			suscribirse("agenteamericano", this);
			dao = new ServidorDAO();
			System.out.println("se conectó al servidor");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} 
	}


	@Override
	public void update(String msg) {
		System.out.println("Imprime controlador suscriptor: " + msg);

		if (msg.equals("Carro")) {
			String cantidad = txtCarros.getText();
			int cant = Integer.parseInt(cantidad);

			txtCarros.setText("" + (cant + 1));
		}
		if (msg.equals("Moto")) {
			String cantidad = txtMotos.getText();
			int cant = Integer.parseInt(cantidad);

			txtMotos.setText("" + (cant + 1));
		}
		if (msg.equals("Bicicleta")) {
			String cantidad = txtBicicletas.getText();
			int cant = Integer.parseInt(cantidad);

			txtBicicletas.setText("" + (cant + 1));
		}
		int cant = Integer.parseInt(txtMotos.getText()) + Integer.parseInt(txtBicicletas.getText())
				+ Integer.parseInt(txtCarros.getText());
		txtVehiculos.setText("" + cant);
	}

	@Override
	public void suscribirse(String name, ControllerInterface controller) throws RemoteException {
		servidorObj.suscribirse(name, controller);
	}

	@FXML
	void initialize() throws SQLException {
		txtBicicletas.setText(""+dao.cargarCantBicicletas());
		txtMotos.setText(""+dao.cargarCantMotos());
		txtCarros.setText(""+dao.cargarCantCarros());
		txtVehiculos.setText(""+dao.cargarCantTotal());
	}
}
