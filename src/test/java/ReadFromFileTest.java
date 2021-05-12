import no.ntnu.idatg2001.file.ReadFromFile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Read from file test.
 */
class ReadFromFileTest {


    private static final Logger LOGGER = Logger.getLogger(ReadFromFileTest.class.getName());

    private File selectedFile;

    /**
     * Read method checking if the file was found and exists after reading it.
     */
    @Test
    @DisplayName("Checks if the file is eligible to be read, if it is read the file will exist and return true")
    void read() {
        LOGGER.info("Adding a new file");
        selectedFile = new File("src/main/resources/Postnummerregister-ansi.txt");
        LOGGER.info("File added, next is to read the file");
        ReadFromFile.read(selectedFile);
        LOGGER.info("Read the file if it exists.");
        boolean afterAdd = selectedFile.exists();

        assertTrue(afterAdd);
    }

    /**
     * Read negative method. Checking that if the file is not found it is not read because no file
     * is there. Fails.
     */
    @Test
    @DisplayName("Checks if the file is not available by giving the file a wrong path, negative test")
    void readNegative() {
        try {
            LOGGER.info("Adding a file that doesn't exist");
            selectedFile = new File("src/test/resources/Postnummerregister-ansi.txt");
            LOGGER.info("No file added");
            ReadFromFile.read(selectedFile);
            LOGGER.info("No file to read.");
            fail("This file is not in the correct location, no file found");
        } catch (Exception e) {
            assertTrue(true);
        }

    }
}