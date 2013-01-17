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
public interface ProfileService {

    public MapLocation getAddress(int profileId);

    public List<String> getInterests(int profileId);

    public List<String> getCommonInterest(int profileId, int anotherProfileId);
}
