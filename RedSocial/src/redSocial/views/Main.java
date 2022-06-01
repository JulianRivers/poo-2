package redSocial.views;

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

        FXMLLoader loader = new FXMLLoader(getClass().getResource("loginPage.fxml"));

        stage.setTitle("Bienvenido");
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
}
