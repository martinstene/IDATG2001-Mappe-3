package no.ntnu.idatg2001.postal;

import javafx.collections.transformation.FilteredList;

import java.util.ArrayList;
import java.util.List;

public class PostalRegister {
    List<PostalCode> postalCodeList;

    public PostalRegister() {
        postalCodeList = new ArrayList<>();
    }

    public List<PostalCode> getPostalCodeList() {
        return postalCodeList;
    }

    public void setPostalCodeList(List<PostalCode> postalCodeList) {
        this.postalCodeList = postalCodeList;
    }
}
