package nl.han.minor.ase.dare2date.webservice;

import nl.han.minor.ase.dare2date.message.DateSuggestionResponse;

public interface DateSuggestionService {

    DateSuggestionResponse getDateSuggestion(final int userId, final int inviteeId);
}
