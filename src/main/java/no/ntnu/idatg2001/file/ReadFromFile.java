package no.ntnu.idatg2001.file;

import java.io.BufferedReader;

import javafx.scene.control.Alert;
import no.ntnu.idatg2001.postal.PostalCode;
import no.ntnu.idatg2001.run.App;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * The type ReadFromFile.
 * @author Martin Stene
 */
public final class ReadFromFile {

    private ReadFromFile() {
    }

    /**
     * Read from a selected file.
     * This is acquired from folder number 2 written by myself. This is because it
     * serves the same purpose as this program wanted to.
     *
     * @param file is read. It checks if the formatting on the file is valid, if not it will throw
     *             an exception which will prompt the user with an alert. This is for the software if
     *             it's developed further where users can add their own files using a FileChooser,
     *             this extra exception will come in handy.
     */
    public static void read(final File file) {
        String line;
        Charset charset = StandardCharsets.ISO_8859_1;
        final String separator = "\t";
        try (BufferedReader br = new BufferedReader(new FileReader(file, charset))) {
            String[] tempArray;
            while ((line = br.readLine()) != null) {
                tempArray = line.split(separator);

                PostalCode postalCode = new PostalCode(tempArray[0], tempArray[1], tempArray[2], tempArray[3], tempArray[4]);
                App.POSTAL_REGISTER.addElements(postalCode);
            }
        } catch (IOException ioexception) {
            ioexception.getCause();
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect file formatting!");
            alert.setHeaderText("Incorrect formatting of .txt file");
            alert.setContentText("To import a .txt file you will need it on the format: "
                    +
                    "PostalCode\tPostalLocation\tMunicipalityCode(ZIP)\tMunicipality\tCategory");
            alert.showAndWait();
        }
    }
}
