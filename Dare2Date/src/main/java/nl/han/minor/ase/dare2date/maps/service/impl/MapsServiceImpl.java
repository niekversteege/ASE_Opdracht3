/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.han.minor.ase.dare2date.maps.service.impl;

import nl.han.minor.ase.dare2date.maps.MapLocation;
import nl.han.minor.ase.dare2date.maps.service.MapsService;
import nl.han.minor.ase.dare2date.profileservice.ProfileService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Niek
 */
public class MapsServiceImpl implements MapsService {

    private final Logger log = Logger.getLogger(this.getClass().getName());
    
    @Autowired
    private ProfileService profileService;
    
    private static final String UNKNOWN = "Unknown";
    private static final String NOKIA_APP_ID = "4FK7DX8Tl9fQS6czRnUw";
    private static final String NOKIA_TOKEN = "KBYlzoAUfx9hVRsedNC1rQ";
    private static final String NOKIA_MAPS_URL = "http://demo.places.nlp.nokia.com/discover/explore?app_id=" + NOKIA_APP_ID + "&app_code=" + NOKIA_TOKEN;

    @Override
    public MapLocation getLocation(int userId, int inviteeId) {

        MapLocation userIdAddress = profileService.getAddress(userId);
        MapLocation inviteeAddress = profileService.getAddress(inviteeId);
        
        // TODO: find usable address based on these two.
        
        MapLocation location = new MapLocation(UNKNOWN, UNKNOWN, UNKNOWN, UNKNOWN, UNKNOWN);
        
        return location;
    }
}
