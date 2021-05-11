import no.ntnu.idatg2001.postal.PostalCode;
import no.ntnu.idatg2001.postal.PostalRegister;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PostalRegisterTest {
    PostalRegister postalRegister = new PostalRegister();

    @BeforeEach
    void setUp() {
        System.out.println("Set up");
        postalRegister.getPostalCodeList().add(new PostalCode("0001", "Oslo",
                "0301", "Oslo", "P"));
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tear down");
        postalRegister.getPostalCodeList().clear();
    }

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