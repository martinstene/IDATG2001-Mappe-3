package no.ntnu.idatg2001.postal;

import java.util.ArrayList;
import java.util.List;

public class PostalRegister implements Register{
    List<PostalCode> postalCodeList;

    public PostalRegister() {
        postalCodeList = new ArrayList<>();
        addSomeCodes();
    }

    public List<PostalCode> getPostalCodeList() {
        return postalCodeList;
    }

    public void setPostalCodeList(List<PostalCode> postalCodeList) {
        this.postalCodeList = postalCodeList;
    }

    public void addSomeCodes(){
        postalCodeList.add(new PostalCode("1","Oslo", "123","Oslo","C"));
        postalCodeList.add(new PostalCode("2","Oslo", "123","Oslo","C"));
        postalCodeList.add(new PostalCode("3","Oslo", "123","Oslo","C"));
    }

    @Override
    public void searchByPostalCode() {

    }

    @Override
    public void searchByMunicipality() {

    }
}
