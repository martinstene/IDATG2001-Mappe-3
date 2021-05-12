import no.ntnu.idatg2001.file.ReadFromFile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Read from file test.
 */
class ReadFromFileTest {

    /**
     * The Selected file.
     */
    File selectedFile;

    /**
     * Read method chekcing if the file was found and exists after reading it.
     */
    @Test
    @DisplayName("Checks if the file is eligable to be read, if it is read the file will exist and return true")
    void read() {
        boolean beforeAdd = false;
        selectedFile = new File("src/main/resources/Postnummerregister-ansi.txt");
        ReadFromFile.read(selectedFile);
        boolean afterAdd = selectedFile.exists();

        assertNotEquals(beforeAdd, afterAdd);
    }

    /**
     * Read negative method. Checking that if the file is not found it is not read because no file
     * is there. Fails.
     */
    @Test
    @DisplayName("Checks if the file is not available by giving the file a wrong path, negative test")
    void readNegative() {
        try {
            selectedFile = new File("src/test/resources/Postnummerregister-ansi.txt");
            ReadFromFile.read(selectedFile);
            fail("This file is not in the correct location");
        } catch (Exception e) {
            assertTrue(true);
        }

    }
}