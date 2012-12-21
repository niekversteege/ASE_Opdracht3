/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.han.minor.ase.dare2date.profile.impl;

import java.util.ArrayList;
import java.util.List;
import nl.han.minor.ase.dare2date.profile.ProfileService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Niek
 */
@Service
public class ProfileServiceImpl implements ProfileService {

    @Override
    public String getAddress(int profileId) {
        return "Adres string voor " + profileId;
    }

    @Override
    public List<String> getInterests(int profileId) {
        List<String> interests = new ArrayList();
        
        interests.add(profileId + " fietsen");
        interests.add(profileId + " bowlen");
        interests.add(profileId + " creatiefmetkurk");
        
        return interests;
    }
}
