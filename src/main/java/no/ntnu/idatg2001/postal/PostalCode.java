package no.ntnu.idatg2001.postal;

public class PostalCode {
    private String postalNumber;
    private String postalLocation;
    private String municipalityCode;
    private String municipality;
    private String category;

    public PostalCode(String postalNumber, String postalLocation, String municipalityCode, String municipality, String category) {
        this.postalNumber = postalNumber;
        this.postalLocation = postalLocation;
        this.municipalityCode = municipalityCode;
        this.municipality = municipality;
        this.category = category;
    }

    public String getPostalNumber() {
        return postalNumber;
    }

    public void setPostalNumber(String postalNumber) {
        this.postalNumber = postalNumber;
    }

    public String getPostalLocation() {
        return postalLocation;
    }

    public void setPostalLocation(String postalLocation) {
        this.postalLocation = postalLocation;
    }

    public String  getMunicipalityCode() {
        return municipalityCode;
    }

    public void setMunicipalityCode(String municipalityCode) {
        this.municipalityCode = municipalityCode;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
