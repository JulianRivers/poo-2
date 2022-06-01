package controllers;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.Fachada;

public class GestorSuscripcionesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void suscribirAmericano(ActionEvent event) {
    	try {
			Fachada.getInstance().addController((ControllerInterface)ControllerPool.getInstance().getController("agenteamericano"));
			System.out.println("=========");
			System.out.println(Fachada.getSuscriptores().get(0).getClass().getName());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void suscribirEuropeo(ActionEvent event) {
    	try {
			Fachada.getInstance().addController((ControllerInterface)ControllerPool.getInstance().getController("agenteeuropeo"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {

    }
}