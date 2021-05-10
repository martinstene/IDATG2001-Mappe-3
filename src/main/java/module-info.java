module no.ntnu.idatg2001 {
    requires javafx.controls;
    requires javafx.fxml;

    exports no.ntnu.idatg2001.run;
    opens no.ntnu.idatg2001.run to javafx.fxml;
}