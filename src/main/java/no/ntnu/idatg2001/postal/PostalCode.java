package no.ntnu.idatg2001.postal;

public class PostalCode {
    private int postalNumber;
    private String postalLocation;
    private int municipalityCode;
    private String municipality;
    private char category;

    public PostalCode(int postalNumber, String postalLocation, int municipalityCode, String municipality, char category) {
        this.postalNumber = postalNumber;
        this.postalLocation = postalLocation;
        this.municipalityCode = municipalityCode;
        this.municipality = municipality;
        this.category = category;
    }

    public int getPostalNumber() {
        return postalNumber;
    }

    public void setPostalNumber(int postalNumber) {
        this.postalNumber = postalNumber;
    }

    public String getPostalLocation() {
        return postalLocation;
    }

    public void setPostalLocation(String postalLocation) {
        this.postalLocation = postalLocation;
    }

    public int getMunicipalityCode() {
        return municipalityCode;
    }

    public void setMunicipalityCode(int municipalityCode) {
        this.municipalityCode = municipalityCode;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public char getCategory() {
        return category;
    }

    public void setCategory(char category) {
        this.category = category;
    }
}
