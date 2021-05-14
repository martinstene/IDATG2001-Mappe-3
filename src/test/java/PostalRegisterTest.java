import no.ntnu.idatg2001.postal.PostalCode;
import no.ntnu.idatg2001.postal.PostalRegister;
import no.ntnu.idatg2001.run.App;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;


/**
 * The type Postal register test.
 * @author Martin Stene
 */
class PostalRegisterTest {
    /**
     * The Postal register.
     */
    private final PostalRegister postalRegister = App.POSTAL_REGISTER;

    private static final Logger LOGGER = Logger.getLogger(PostalRegisterTest.class.getName());

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        LOGGER.info("Setting up by adding a PostalCode to the list");
        postalRegister.getPostalCodeList().add(new PostalCode("0001", "Oslo",
                "0301", "Oslo", "P"));
    }

    /**
     * Tear down.
     */
    @AfterEach
    void tearDown() {
        LOGGER.info("Tear down, clearing list and ready for the next test");
        postalRegister.getPostalCodeList().clear();
    }

    /**
     * Add elements. Positive test to see if the before size of the list i equal to the after size
     * after adding a new PostalCode.
     */
    @Test
    @DisplayName("Testing to see if the method returns a different result after adding using the method created." +
            " This is a positive test which should not result in a fail.")
    void addElements() {
        int before = postalRegister.getPostalCodeList().size();
        postalRegister.addElements(new PostalCode("0010", "Oslo",
                "0301", "Oslo", "P"));
        int after = postalRegister.getPostalCodeList().size();

        assertNotEquals(before, after);
    }

    /**
     * Add elements negative. Checking if you are able to create an empty PostalCode.
     * Method fails because this should not work.
     */
    @Test
    @DisplayName("Testing negatively to see that the method will return false when a wrong action is occurring.")
    void addElementsNegative() {
        try {
            postalRegister.addElements(new PostalCode("", "",
                    "", "", ""));
            fail("You should not be able to add an element with all empty strings.");
        } catch (Exception e) {
            assertTrue(true);
        }
    }
}
