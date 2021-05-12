package no.ntnu.idatg2001.postal;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Postal register.
 */
public class PostalRegister {
    /*
     * Creating a list which will be used all throughout the project
     * I create a List<> here instead of an ObservableList because I want the business
     * logic to be separated from the GUI elements such as the ObservableList.
     */
    private List<PostalCode> postalCodeList;

    /**
     * Instantiates a new Postal register.
     */
    public PostalRegister() {
        postalCodeList = new ArrayList<>();
    }

    /**
     * Gets postal code list.
     *
     * @return the postal code list
     */
    public List<PostalCode> getPostalCodeList() {
        return postalCodeList;
    }

    /**
     * Sets postal code list.
     *
     * @param postalCodeList the postal code list
     */
    public void setPostalCodeList(List<PostalCode> postalCodeList) {
        this.postalCodeList = postalCodeList;
    }

    /**
     * Adds elements to the list using this method instead of the one provided by List.
     * This is using the one provided, but now in a another method for better cohesion.
     *
     * @param postalCode the postal code
     */
    public void addElements(PostalCode postalCode) {
        postalCodeList.add(postalCode);
    }
}
