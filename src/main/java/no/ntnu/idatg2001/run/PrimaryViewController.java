package no.ntnu.idatg2001.run;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
    private TextField filterPostalCode;
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

    @Override
    public void getPostalCodes(){
        postalCodeObservableList.addAll(App.postalRegister.getPostalCodeList());

        tableView.setItems(postalCodeObservableList);
    }

    @Override
    public void readFromFile() throws IOException {
        try {
            File selectedFile = new File("src/main/resources/Postnummerregister-ansi.txt");
            ReadFromFile.read(selectedFile);
        } catch (NullPointerException ignored){}
    }

    @Override
    public void search(){
        // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<PostalCode> filteredList = new FilteredList<>(postalCodeObservableList, b -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        filterPostalCode.textProperty().addListener((observable, oldValue, newValue) -> {
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
            });
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<PostalCode> sortedData = new SortedList<>(filteredList);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tableView.setItems(sortedData);
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
