/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.han.minor.ase.dare2date.maps;

/**
 *
 * @author Niek
 */
public class MapLocation {

    private String street, number, town, postcode, country;

    public MapLocation(String town, String street, String number, String postcode, String country) {
        this.town = town;
        this.street = street;
        this.number = number;
        this.postcode = postcode;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getTown() {
        return town;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCountry() {
        return country;
    }    
}
