package poo2.redsocial.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import poo2.redsocial.model.Fachada;
import poo2.redsocial.model.PublicacionDTO;
import poo2.redsocial.model.UsuarioDTO;

public class PublicacionController implements Initializable{
	
	private Fachada fachada;
	
	@FXML
	private TextField txPublicacion;
	@FXML
	private TextArea taPublicaciones;
	@FXML
	private ComboBox<String> cmbUsuarios;
	
	/**
	 * Importante tener presente que los objetos de la GUI
	 * deben inicializarse sobreescribiendo el método initialize
	 * de la interfaz Initializable.
	 */
	public PublicacionController() {
		fachada = Fachada.getInstance();
	}

	/**
	 * Este método valida las credenciales de autenticación del usuario.
	 * Se usa en la vista iniciosesion.fxml.
	 * @param event
	 */
	@FXML
	protected void handleVerButtonAction(ActionEvent event) {
			
		refrescarPublicaciones();
		
	}
	
	private void refrescarPublicaciones() {
		
		taPublicaciones.clear();	
		
		ArrayList<PublicacionDTO> listaPublicaciones = fachada.listarPublicacionesUsuario(cmbUsuarios.getSelectionModel().getSelectedItem());
		if(listaPublicaciones!=null) {
			for(PublicacionDTO dto : listaPublicaciones) {
				taPublicaciones.appendText(dto.getTexto());
				taPublicaciones.appendText("\n");
				
				String fecha = dto.getFechaPublicacion().get(Calendar.DATE) + "/" +
						(dto.getFechaPublicacion().get(Calendar.MONTH) + 1) + "/" +
						dto.getFechaPublicacion().get(Calendar.YEAR); 
				
				taPublicaciones.appendText(fecha);
				taPublicaciones.appendText("\n\n");
			}
		
		}else
			taPublicaciones.setText("No hay publicaciones");
	}
	
	@FXML
	protected void handleEnviarButtonAction(ActionEvent event) {
		String textoPublicacion = txPublicacion.getText();
		if(textoPublicacion!=null && textoPublicacion.length()>0) {
			
			String usuario = cmbUsuarios.getSelectionModel().getSelectedItem();			
			fachada.crearPublicacion(usuario, textoPublicacion);
			refrescarPublicaciones();
			txPublicacion.clear();
			
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Ingreso de Información");
			alert.setHeaderText(null);
			alert.setContentText("Debe ingresar el texto de la publicación");

			alert.showAndWait();
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ArrayList<UsuarioDTO> listaUsuarios = fachada.listarUsuarios();
		
		if(listaUsuarios!=null) {
			cmbUsuarios.getItems().clear();
				
			for(UsuarioDTO dto : listaUsuarios) {
				cmbUsuarios.getItems().add(dto.getNombres());
			}
		
		}
		
	}
	
}
