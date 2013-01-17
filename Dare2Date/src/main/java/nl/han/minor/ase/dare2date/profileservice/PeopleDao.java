/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.han.minor.ase.dare2date.profileservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import nl.han.minor.ase.dare2date.maps.MapLocation;

/**
 *
 * @author Niek
 */
public class PeopleDao {

    public static Map<Integer, Person> getPeople() {
        Map<Integer, Person> people = new HashMap<Integer, Person>();
        // plaats straat nummer postcode land
        MapLocation henkAddress = new MapLocation("Arnhem", "Ruiterberglaan", "26", "6826 CC", "Nederland");
        List<String> henkInterests = new ArrayList<String>();
        henkInterests.add("fietsen");
        henkInterests.add("bowlen");
        henkInterests.add("poker");
        Person henkJanssen = new Person(henkAddress, henkInterests);
        people.put(444, henkJanssen);
        
        MapLocation truusAddress = new MapLocation("Ruurlo", "Brinklaan", "62", "5643 AA", "Nederland");
        List<String> truusInterests = new ArrayList<String>();
        truusInterests.add("zwemmen");
        truusInterests.add("fietsen");
        truusInterests.add("creatiefmetkurk");
        Person truusWillemsen = new Person(truusAddress, truusInterests);
        people.put(545, truusWillemsen);
        
        return people;
    }
    
}
