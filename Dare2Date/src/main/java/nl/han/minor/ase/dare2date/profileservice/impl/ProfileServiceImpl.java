/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.han.minor.ase.dare2date.profileservice.impl;

import java.lang.Integer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import nl.han.minor.ase.dare2date.maps.MapLocation;
import nl.han.minor.ase.dare2date.profileservice.PeopleDao;
import nl.han.minor.ase.dare2date.profileservice.Person;
import nl.han.minor.ase.dare2date.profileservice.ProfileService;

/**
 *
 * @author Niek
 */
public class ProfileServiceImpl implements ProfileService {
    
    private Map<Integer, Person> people = PeopleDao.getPeople();

    @Override
    public MapLocation getAddress(int profileId) {
        
        return people.get(profileId).getAddress();
    }

    @Override
    public List<String> getInterests(int profileId) {
        
        return people.get(profileId).getInterests();
    }

    @Override
    public List<String> getCommonInterest(int profileId, int anotherProfileId) {
        List<String> commonInterests = new ArrayList<String>();

        List firstInterests = getInterests(profileId);
        List secondInterests = getInterests(anotherProfileId);

        commonInterests.addAll(firstInterests);
        commonInterests.retainAll(secondInterests);

        return commonInterests;
    }
}
