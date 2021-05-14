package no.ntnu.idatg2001.run;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import no.ntnu.idatg2001.postal.PostalRegister;

import java.io.IOException;

/**
 * JavaFX App class.
 * @author Martin Stene
 */
public final class App extends Application {

    /**
     * The constant POSTAL_REGISTER. This will be used to access business method in the GUI.
     */
    public static final PostalRegister POSTAL_REGISTER = PostalRegister.getCreatedPostalRegisterInstance();

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(loadFXML("PrimaryView"));
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This is a simple method from the maven archetype which creates a bit more cohesion.
     *
     * @param fxml is the fxml file you want to show
     * @return the fxml loaded
     * @throws IOException ioexception
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getClassLoader().getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch();
    }

}
