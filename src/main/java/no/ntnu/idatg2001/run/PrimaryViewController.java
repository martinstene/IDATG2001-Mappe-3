package no.ntnu.idatg2001.run;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import no.ntnu.idatg2001.file.ReadFromFile;
import no.ntnu.idatg2001.postal.PostalCode;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryViewController implements Initializable {

    @FXML
    private TableView tableView;
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

    public void getPostalCodes(){
        ObservableList<PostalCode> patientsObservableList = FXCollections.observableArrayList();
        patientsObservableList.addAll(App.postalRegister.getPostalCodeList());

        tableView.setItems(patientsObservableList);
    }

    @FXML
    public void handleSearchByPostalCode() {

    }

    @FXML
    public void handleSearchByMunicipality() {

    }

    public void readFromFile() throws IOException {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files", "*.txt"));
            Stage stage = new Stage();
            File selectedFile = fileChooser.showOpenDialog(stage);
            ReadFromFile.read(selectedFile);
            getPostalCodes(); // This is for updating the tableview after adding a new Patient
        } catch (NullPointerException ignored){}
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        postalCodeColumn.setCellValueFactory(new PropertyValueFactory<>("postalNumber"));
        postalLocationColumn.setCellValueFactory(new PropertyValueFactory<>("postalLocation"));
        municipalityCodeColumn.setCellValueFactory(new PropertyValueFactory<>("municipalityCode"));
        municipalityColumn.setCellValueFactory(new PropertyValueFactory<>("municipality"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        getPostalCodes();
    }
}
