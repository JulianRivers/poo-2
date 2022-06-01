package views;


import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainAgente extends Application {

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ExternalAgent.fxml"));

            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) throws Exception {
        Application.launch(MainAgente.class, args);
    }
}
