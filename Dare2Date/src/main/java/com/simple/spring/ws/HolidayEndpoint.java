package com.simple.spring.ws;

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
public class HolidayEndpoint {

    private static final String NAMESPACE_URI = "http://simple-sample.com/dd/";
    public static final String XPATH_USER_ID = "//UserId";
    public static final String XPATH_INVITEE_ID = "//InviteeId";
    private XPath userExpression;
    private XPath inviteeExpression;
    private HumanResourceService dateSuggestionService;

    @Autowired
    public HolidayEndpoint(HumanResourceService dateSuggestionService)
            throws JDOMException {

        this.dateSuggestionService = dateSuggestionService;

        Namespace namespace = Namespace.getNamespace("spring", NAMESPACE_URI);

        userExpression = XPath.newInstance(XPATH_USER_ID);
        userExpression.addNamespace(namespace);

        inviteeExpression = XPath.newInstance(XPATH_INVITEE_ID);
        inviteeExpression.addNamespace(namespace);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "HolidayRequest")
    public void handleHolidayRequest(@RequestPayload Element dateSuggestion)
            throws Exception {

        int userId = 0;
        int inviteeId = 0;

        try {
            userId = Integer.parseInt(userExpression.valueOf(dateSuggestion));
            inviteeId = Integer.parseInt(inviteeExpression.valueOf(dateSuggestion));
        } catch (NumberFormatException e) {
            log.error("Received non-int userIds.", e);
        }

        String date = dateSuggestionService.getDateSuggestion(userId, inviteeId);
        log.debug(date);
    }
}