import no.ntnu.idatg2001.postal.PostalCode;
import no.ntnu.idatg2001.postal.PostalRegister;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * The type Postal register test.
 */
class PostalRegisterTest {
    /**
     * The Postal register.
     */
    PostalRegister postalRegister = new PostalRegister();

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        System.out.println("Set up, adding a PostalCode to the list");
        postalRegister.getPostalCodeList().add(new PostalCode("0001", "Oslo",
                "0301", "Oslo", "P"));
    }

    /**
     * Tear down.
     */
    @AfterEach
    void tearDown() {
        System.out.println("Tear down, clearing list and ready for the next test");
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
     * Add elements negative. Chekcing if you are able to create an empty PostalCode.
     * Method fails because this should not work.
     */
    @Test
    @DisplayName("Testing negatively to see that the method will return false when a wrong action is occuring.")
    void addElementsNegative(){
        try {
            postalRegister.addElements(new PostalCode("", "",
                    "", "", ""));
            fail("You should not be able to add an element with all empty strings.");
        } catch (Exception e){
            assertTrue(true);
        }
    }
}