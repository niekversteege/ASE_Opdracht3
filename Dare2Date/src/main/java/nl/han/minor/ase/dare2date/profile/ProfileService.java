/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.han.minor.ase.dare2date.profile;

import java.util.List;

/**
 *
 * @author Niek
 */
public interface ProfileService {

    public String getAddress(int profileId);

    public List<String> getInterests(int profileId);
}
