package no.ntnu.idatg2001.file;

import javafx.scene.control.Alert;
import no.ntnu.idatg2001.postal.PostalCode;
import no.ntnu.idatg2001.run.App;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {

    private ReadFromFile() {
    }

    /**
     * Read from a selected file.
     * This is acquired from folder number 2 written by myself. This is because it
     * serves the same purpose as this program wanted to.
     *
     * @param file the file
     */
    public static void read(File file) throws IOException {
        String line;
        final String separator = "\t";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String[] tempArray;
            while ((line = br.readLine()) != null) {
                tempArray = line.split(separator);

                PostalCode postalCode = new PostalCode(tempArray[0], tempArray[1], tempArray[2], tempArray[3],tempArray[4]);
                App.postalRegister.getPostalCodeList().add(postalCode);
            }
        } catch (IOException e) {
            e.getCause();
        } catch (ArrayIndexOutOfBoundsException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect file formatting!");
            alert.setHeaderText("Incorrect formatting of .csv file");
            alert.setContentText("To import a .csv file you will need it on the format: " +
                    "firstname;lastname;generalPractitioner;socialSecurityNumber;diagnosis");
            alert.showAndWait();
        }
    }
}
