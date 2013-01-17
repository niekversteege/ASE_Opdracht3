/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.han.minor.ase.dare2date.maps.service;

import nl.han.minor.ase.dare2date.maps.MapLocation;

/**
 *
 * @author Niek
 */
public interface MapsService {
    
    public MapLocation getLocation(int userId, int inviteeId);
}
