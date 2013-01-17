package nl.han.minor.ase.dare2date.webservice.impl;

import nl.han.minor.ase.dare2date.maps.MapLocation;
import nl.han.minor.ase.dare2date.maps.service.MapsService;
import nl.han.minor.ase.dare2date.message.DateSuggestionResponse;
import nl.han.minor.ase.dare2date.profileservice.ProfileService;
import nl.han.minor.ase.dare2date.types.DateSuggestion;
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
    public DateSuggestionResponse getDateSuggestion(final int userId, final int inviteeId) {

        DateSuggestion suggestion = new DateSuggestion();

        suggestion.setActivity(profileService.getCommonInterest(userId, inviteeId).toString());

        MapLocation location = mapsService.getLocation(userId, inviteeId);

        suggestion.setLocation(location);

        DateSuggestionResponse retVal = new DateSuggestionResponse(suggestion);

        return retVal;
    }
}
