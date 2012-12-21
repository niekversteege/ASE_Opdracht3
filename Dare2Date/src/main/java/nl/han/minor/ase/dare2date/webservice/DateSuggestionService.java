package nl.han.minor.ase.dare2date.webservice;

public interface DateSuggestionService {
    
    String getDateSuggestion(final int userId, final int inviteeId);
}
