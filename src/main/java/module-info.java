module no.ntnu.idatg {
    requires javafx.controls;
    requires javafx.fxml;


    opens no.ntnu.idatg2001.file to java.base;
    exports no.ntnu.idatg2001.file;
    opens no.ntnu.idatg2001.postal to javafx.fxml;
    exports no.ntnu.idatg2001.postal;
    exports no.ntnu.idatg2001.run;
    opens no.ntnu.idatg2001.run to javafx.fxml;
}