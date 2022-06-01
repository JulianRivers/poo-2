package poo2.redsocial.views;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	
	public static void main(String[] args) {
        Application.launch(Main.class, args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("VerPublicaciones.fxml"));
    	
        stage.setTitle("Red Social 3.0");
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
}
