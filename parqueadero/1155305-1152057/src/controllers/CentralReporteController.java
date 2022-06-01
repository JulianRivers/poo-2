/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Fachada;

public class CentralReporteController implements ControllerInterface {

    @FXML
    private TextField txtCarros;

    @FXML
    private TextField txtMotos;

    @FXML
    private TextField txtBicicletas;

    @FXML
    private TextField txtVehiculos;

    public CentralReporteController() {
        txtCarros = new TextField();
        txtMotos = new TextField();
        txtBicicletas = new TextField();
        txtVehiculos = new TextField();
         if (txtCarros.getText().isBlank()) {
            txtCarros.setText("0");
        }
        if (txtMotos.getText().isBlank()) {
            txtMotos.setText("0");
        }
        if (txtBicicletas.getText().isBlank()) {
            txtBicicletas.setText("0");
        }
        if (txtVehiculos.getText().isBlank()) {
            txtVehiculos.setText("0");
        }
        ControllersPool.getInstance().addController("CentralReportesAmericano", this);
    }
    
    @FXML
    public void handleSuscribirse(ActionEvent ev) {
        // Obtener instancia de la fachada (publicador)
        // Suscribirse
        Fachada.getInstance().addController(this);
        System.out.println("Suscribiendo... ");
    }

    @Override
    public void update(String msg) {
        System.out.println("Imprime controlador suscriptor: " + msg);

        if (msg.equals("Carro")) {
            String cantidad = txtCarros.getText();
            if (cantidad.isBlank()) {
                cantidad = "0";
            }

            int cant = Integer.parseInt(cantidad);

            txtCarros.setText("" + (cant + 1));
        }
        if(msg.equals("Moto")){
            String cantidad = txtMotos.getText();
            if (cantidad.isBlank()) {
                cantidad = "0";
            }

            int cant = Integer.parseInt(cantidad);

            txtMotos.setText("" + (cant + 1));
        }
        if(msg.equals("Bicicleta")){
            String cantidad = txtBicicletas.getText();
            if (cantidad.isBlank()) {
                cantidad = "0";
            }

            int cant = Integer.parseInt(cantidad);

            txtBicicletas.setText("" + (cant + 1));
        }
        
        int cant = Integer.parseInt(txtMotos.getText())+Integer.parseInt(txtBicicletas.getText())+Integer.parseInt(txtCarros.getText());
        txtVehiculos.setText(""+cant);
    }

    @FXML
    void initialize() {
        assert txtCarros != null : "fx:id=\"txtCarros\" was not injected: check your FXML file 'ExternalAgent.fxml'.";
        assert txtMotos != null : "fx:id=\"txtMotos\" was not injected: check your FXML file 'ExternalAgent.fxml'.";
        assert txtBicicletas != null : "fx:id=\"txtBicicletas\" was not injected: check your FXML file 'ExternalAgent.fxml'.";
        assert txtVehiculos != null : "fx:id=\"txtVehiculos\" was not injected: check your FXML file 'ExternalAgent.fxml'.";
        if (txtCarros.getText().isBlank()) {
            txtCarros.setText("0");
        }
        if (txtMotos.getText().isBlank()) {
            txtMotos.setText("0");
        }
        if (txtBicicletas.getText().isBlank()) {
            txtBicicletas.setText("0");
        }
        if (txtVehiculos.getText().isBlank()) {
            txtVehiculos.setText("0");
        }
    }
}
