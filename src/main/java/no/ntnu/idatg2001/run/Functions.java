package no.ntnu.idatg2001.run;

import java.io.IOException;

/**
 * The interface Functions.
 */
public interface Functions {
    /**
     * Gets postal codes.
     */
    void getPostalCodes();

    /**
     * Read from file.
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
