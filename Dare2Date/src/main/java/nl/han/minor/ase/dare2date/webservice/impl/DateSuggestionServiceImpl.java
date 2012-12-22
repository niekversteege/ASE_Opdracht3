package nl.han.minor.ase.dare2date.webservice.impl;

import nl.han.minor.ase.dare2date.webservice.DateSuggestionService;
import org.apache.log4j.Logger;

public class DateSuggestionServiceImpl implements DateSuggestionService {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Override
    public String getDateSuggestion(final int userId, final int inviteeId) {

        String retVal = null;

        if (userId != 0 && inviteeId != 0) {
            retVal = "A date at blabla for " + userId + " and the invited " + inviteeId + ". Doing stuff.";
        }

        return retVal;
    }
}
