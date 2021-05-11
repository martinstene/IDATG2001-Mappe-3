package no.ntnu.idatg2001.postal;

/**
 * The type Postal code.
 */
public class PostalCode {
    private String postalNumber;
    private String postalLocation;
    private String municipalityCode;
    private String municipality;
    private String category;

    /**
     * Instantiates a new Postal code.
     *
     * @param postalNumber     the postal number
     * @param postalLocation   the postal location
     * @param municipalityCode the municipality code
     * @param municipality     the municipality
     * @param category         the category
     */
    public PostalCode(String postalNumber, String postalLocation, String municipalityCode, String municipality, String category) {
        this.postalNumber = postalNumber;
        this.postalLocation = postalLocation;
        this.municipalityCode = municipalityCode;
        this.municipality = municipality;
        this.category = category;
    }

    /**
     * Gets postal number.
     *
     * @return the postal number
     */
    public String getPostalNumber() {
        return postalNumber;
    }

    /**
     * Sets postal number.
     *
     * @param postalNumber the postal number
     */
    public void setPostalNumber(String postalNumber) {
        this.postalNumber = postalNumber;
    }

    /**
     * Gets postal location.
     *
     * @return the postal location
     */
    public String getPostalLocation() {
        return postalLocation;
    }

    /**
     * Sets postal location.
     *
     * @param postalLocation the postal location
     */
    public void setPostalLocation(String postalLocation) {
        this.postalLocation = postalLocation;
    }

    /**
     * Gets municipality code.
     *
     * @return the municipality code
     */
    public String  getMunicipalityCode() {
        return municipalityCode;
    }

    /**
     * Sets municipality code.
     *
     * @param municipalityCode the municipality code
     */
    public void setMunicipalityCode(String municipalityCode) {
        this.municipalityCode = municipalityCode;
    }

    /**
     * Gets municipality.
     *
     * @return the municipality
     */
    public String getMunicipality() {
        return municipality;
    }

    /**
     * Sets municipality.
     *
     * @param municipality the municipality
     */
    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    /**
     * Gets category.
     *
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(String category) {
        this.category = category;
    }
}
