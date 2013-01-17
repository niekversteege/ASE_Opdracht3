/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.han.minor.ase.dare2date.profileservice.impl;

import java.util.ArrayList;
import java.util.List;
import nl.han.minor.ase.dare2date.profileservice.ProfileService;

/**
 *
 * @author Niek
 */
public class ProfileServiceImpl implements ProfileService {

    private static final int HENK_JANSSEN = 444;
    private static final int WILLEKEURIGE_VROUW = 545;

    @Override
    public String getAddress(int profileId) {
        String adres = null;

        switch (profileId) {
            case HENK_JANSSEN:
                adres = "Straatvanhenkjanssen 4";
                break;
            case WILLEKEURIGE_VROUW:
                adres = "Straatvanwillekeurigevrouw 10";
                break;
        }

        return adres;
    }

    @Override
    public List<String> getInterests(int profileId) {
        List<String> interests = null;

        switch (profileId) {
            case HENK_JANSSEN:
                interests = getHenkJanssenInterests();
                break;
            case WILLEKEURIGE_VROUW:
                interests = getWillekeurigeVrouwInterests();
                break;
        }

        return interests;
    }

    private List<String> getHenkJanssenInterests() {

        List<String> interests = new ArrayList();

        interests.add("fietsen");
        interests.add("bowlen");
        interests.add("creatiefmetkurk");

        return interests;
    }

    private List<String> getWillekeurigeVrouwInterests() {
        List<String> interests = new ArrayList();

        interests.add("fietsen");
        interests.add("roken");
        interests.add("jam maken");

        return interests;
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
