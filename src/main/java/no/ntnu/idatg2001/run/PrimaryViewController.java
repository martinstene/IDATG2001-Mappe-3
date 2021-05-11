package no.ntnu.idatg2001.run;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import no.ntnu.idatg2001.file.ReadFromFile;
import no.ntnu.idatg2001.postal.PostalCode;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryViewController implements Initializable, Functions {

    @FXML
    private TextField filterPostalCodeTextField;
    @FXML
    private TableView<PostalCode> tableView;
    @FXML
    private TableColumn<Object, Object> postalCodeColumn;
    @FXML
    private TableColumn<Object, Object> postalLocationColumn;
    @FXML
    private TableColumn<Object, Object> municipalityCodeColumn;
    @FXML
    private TableColumn<Object, Object> municipalityColumn;
    @FXML
    private TableColumn<Object, Object> categoryColumn;

    private final ObservableList<PostalCode> postalCodeObservableList = FXCollections.observableArrayList();

    @FXML
    private void handleExitButton() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("Do you really want to exit the application?");
        alert.setContentText("Are you ok with this?");
        alert.showAndWait();

        if (alert.getResult() == ButtonType.OK) {
            System.exit(0);
        } else {
            alert.close();
        }
    }

    @FXML
    private void handleAboutButton() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setContentText("This is a brilliant application made by \n C\nMartin Stene");
        alert.showAndWait();
    }

    @Override
    public void getPostalCodes() {
        postalCodeObservableList.addAll(App.postalRegister.getPostalCodeList());
        tableView.setItems(postalCodeObservableList);
    }

    @Override
    public void readFromFile() throws IOException {
        try {
            File selectedFile = new File("src/main/resources/Postnummerregister-ansi.txt");
            if (selectedFile.exists()){
                ReadFromFile.read(selectedFile);
            }
        } catch (NullPointerException ignored) {}
    }

    /**
     * Source code taken from https://www.youtube.com/watch?v=FeTrcNBVWtg
     * Reasoning for using this code is because it uses lambda expressions in a good way,
     * also does what I want it to.
     *
     * It does what the assignment says and in a sophisticated manner. It sets the list of initial
     * elements in a filtered list then uses a listener to always check the value of the text field, this
     * makes it more user friendly, and when the user starts typing they will immediately see results
     * gathered from the search, no need to click the enter button which was my original design.
     *
     */
    @Override
    public void search() {
        try {
            // Wrap the ObservableList in a FilteredList (initially display all data).
            FilteredList<PostalCode> filteredList = new FilteredList<>(postalCodeObservableList, s -> true);

            // 2. Set the filter Predicate whenever the filter changes.
            filterPostalCodeTextField.textProperty().addListener((observable, oldValue, newValue) ->
                    filteredList.setPredicate(postalCode -> {
                        // If filter text is empty, display all persons.

                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }

                        // Compare first name and last name of every person with filter text.
                        String lowerCaseFilter = newValue.toLowerCase();

                        if (postalCode.getPostalNumber().toLowerCase().contains(lowerCaseFilter)) {
                            return true; // Filter matches first name.
                        } else // Does not match.
                            if (postalCode.getMunicipalityCode().toLowerCase().contains(lowerCaseFilter)) {
                                return true; // Filter matches last name.
                            } else return postalCode.getMunicipality().toLowerCase().contains(lowerCaseFilter);
                    }));
            tableView.setItems(filteredList);

        } catch (NullPointerException ignored) {
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        postalCodeColumn.setCellValueFactory(new PropertyValueFactory<>("postalNumber"));
        postalLocationColumn.setCellValueFactory(new PropertyValueFactory<>("postalLocation"));
        municipalityCodeColumn.setCellValueFactory(new PropertyValueFactory<>("municipalityCode"));
        municipalityColumn.setCellValueFactory(new PropertyValueFactory<>("municipality"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        try {
            readFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        getPostalCodes();

        search();
    }
}
