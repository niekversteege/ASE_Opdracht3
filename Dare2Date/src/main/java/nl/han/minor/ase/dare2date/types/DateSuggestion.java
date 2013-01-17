package nl.han.minor.ase.dare2date.types;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import nl.han.minor.ase.dare2date.maps.MapLocation;

@XmlRootElement(name = "DateSuggestionResponse", namespace = "http://dare2date.com/dd/")
@XmlAccessorType
@XmlType
public class DateSuggestion implements Serializable {

    private String street, number, town, postcode, country, activity;

    public DateSuggestion() {
    }

    public DateSuggestion(String town, String street, String number, String postcode, String country, String activity) {

        this.town = town;
        this.street = street;
        this.number = number;
        this.postcode = postcode;
        this.country = country;
        this.activity = activity;
    }

    /**
     * @return the street
     */
    @XmlElement(name = "street", namespace = "http://dare2date.com/dd/")
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the number
     */
    @XmlElement(name = "number", namespace = "http://dare2date.com/dd/")
    public String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return the town
     */
    @XmlElement(name = "town", namespace = "http://dare2date.com/dd/")
    public String getTown() {
        return town;
    }

    /**
     * @param town the town to set
     */
    public void setTown(String town) {
        this.town = town;
    }

    /**
     * @return the postcode
     */
    @XmlElement(name = "postcode", namespace = "http://dare2date.com/dd/")
    public String getPostcode() {
        return postcode;
    }

    /**
     * @param postcode the postcode to set
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * @return the country
     */
    @XmlElement(name = "country", namespace = "http://dare2date.com/dd/")
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the activity
     */
    @XmlElement(name = "activity", namespace = "http://dare2date.com/dd/")
    public String getActivity() {
        return activity;
    }

    /**
     * @param activity the activity to set
     */
    public void setActivity(String activity) {
        this.activity = activity;
    }

    public void setLocation(MapLocation location) {
        setCountry(location.getCountry());
        setNumber(location.getNumber());
        setPostcode(location.getPostcode());
        setStreet(location.getStreet());
        setTown(location.getTown());
    }
}
