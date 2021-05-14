package no.ntnu.idatg2001.run;

import java.io.IOException;

/**
 * The interface Functions.
 * Used for holding the methods that are not fxml but still used in the GUI
 * @author Martin Stene
 */
public interface IPrimaryViewController {
    /**
     * Gets postal codes to the observable list from the normal list.
     * It then sets these elements to the tableview so that the user can see.
     */
    void getPostalCodes();

    /**
     * Read from file and sets the content of the file to the tableview.
     * Checks if the file inserted exists and then uses the read() method from ReadFromFile.
     *
     * @throws IOException the io exception
     */
    void readFromFile() throws IOException;

    /**
     * This is a search method, it searches through the list and filters out the matches based
     * on certain aspects in the table.
     */
    void search();
}
