/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.han.minor.ase.dare2date.profileservice;

import java.util.List;
import nl.han.minor.ase.dare2date.maps.MapLocation;

/**
 *
 * @author Niek
 */
public class Person {
    
    private MapLocation address;
    private List<String> interests;
    
    public Person(MapLocation address, List<String> interests) {
        
        this.address = address;
        this.interests = interests;
    }

    public MapLocation getAddress() {
        return address;
    }

    public List<String> getInterests() {
        return interests;
    }
}
