package com.simple.spring.ws;

import lombok.extern.log4j.Log4j;

@Log4j
public class SimpleHumanResourceService implements HumanResourceService {

    @Override
    public String getDateSuggestion(final int userId, final int inviteeId) {

        String retVal = null;

        if (userId != 0 && inviteeId != 0) {
            retVal = "A date at blabla for " + userId + " and the invited " + inviteeId + ". Doing stuff.";
        }

        return retVal;
    }
}
