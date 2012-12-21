package nl.han.minor.ase.dare2date.webservice;

import lombok.extern.log4j.Log4j;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.xpath.XPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

@Endpoint
@Log4j
public class DateSuggestionEndpoint {

    private static final String NAMESPACE_URI = "http://dare2date.com/dd/";
    public static final String XPATH_USER_ID = "//UserId";
    public static final String XPATH_INVITEE_ID = "//InviteeId";
    private XPath userExpression;
    private XPath inviteeExpression;
    private DateSuggestionService dateSuggestionService;

    @Autowired
    public DateSuggestionEndpoint(DateSuggestionService dateSuggestionService)
            throws JDOMException {

        this.dateSuggestionService = dateSuggestionService;

        Namespace namespace = Namespace.getNamespace("spring", NAMESPACE_URI);

        userExpression = XPath.newInstance(XPATH_USER_ID);
        userExpression.addNamespace(namespace);

        inviteeExpression = XPath.newInstance(XPATH_INVITEE_ID);
        inviteeExpression.addNamespace(namespace);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DateSuggestionRequest")
    public void handleDateSuggestionRequest(@RequestPayload Element dateSuggestion)
            throws Exception {

        int userId = 0;
        int inviteeId = 0;

        String userString = userExpression.valueOf(dateSuggestion);
        String inviteeString = inviteeExpression.valueOf(dateSuggestion);

        log.debug("Received: " + userString + ". And: " + inviteeString + ".");
        
        if (!userString.isEmpty() && !inviteeString.isEmpty()) {
            try {
                userId = Integer.parseInt(userString);
                inviteeId = Integer.parseInt(inviteeString);

            } catch (NumberFormatException e) {
                log.error("Received non-int userIds.", e);
            }

            String date = dateSuggestionService.getDateSuggestion(userId, inviteeId);
            log.debug("Date string: " + date);
        }
        else {
            log.warn("Received empty user and invitee IDs");
        }
    }
}