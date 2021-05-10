package no.ntnu.idatg2001.run;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import no.ntnu.idatg2001.postal.PostalRegister;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    public static final PostalRegister postalRegister = new PostalRegister();

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(loadFXML("PrimaryView"));
        stage.setScene(scene);
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getClassLoader().getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}