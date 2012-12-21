package nl.han.minor.ase.dare2date.webservice.impl;

import lombok.extern.log4j.Log4j;
import nl.han.minor.ase.dare2date.webservice.DateSuggestionService;

@Log4j
public class DateSuggestionServiceImpl implements DateSuggestionService {

    @Override
    public String getDateSuggestion(final int userId, final int inviteeId) {

        String retVal = null;

        if (userId != 0 && inviteeId != 0) {
            retVal = "A date at blabla for " + userId + " and the invited " + inviteeId + ". Doing stuff.";
        }

        return retVal;
    }
}
