package nl.han.minor.ase.dare2date.webservice.impl;

import nl.han.minor.ase.dare2date.nokiamaps.service.MapsService;
import nl.han.minor.ase.dare2date.profileservice.ProfileService;
import nl.han.minor.ase.dare2date.webservice.DateSuggestionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class DateSuggestionServiceImpl implements DateSuggestionService {

    private final Logger log = Logger.getLogger(this.getClass().getName());
    
    @Autowired
    private ProfileService profileService;
    
    @Autowired
    private MapsService mapsService;

    @Override
    public String getDateSuggestion(final int userId, final int inviteeId) {

        String retVal = null;

        if (userId != 0 && inviteeId != 0) {
            retVal = "A date at blabla for " + userId + " and the invited " + inviteeId + ". Doing stuff. At address: " + mapsService.getLocation();
        }
        
        log.debug("Address for userId: " + profileService.getAddress(userId));
        log.debug("Address for inviteeId: " + profileService.getAddress(inviteeId));

        return retVal;
    }
}
