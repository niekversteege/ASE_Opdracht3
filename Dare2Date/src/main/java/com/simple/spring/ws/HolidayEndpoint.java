package com.simple.spring.ws;

import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.xpath.XPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import java.text.SimpleDateFormat;
import java.util.Date;

@Endpoint
public class HolidayEndpoint {

    private static final String NAMESPACE_URI = "http://simple-sample.com/dd/";

    private XPath startDateExpression;

    private XPath endDateExpression;

    private XPath nameExpression;

    private HumanResourceService humanResourceService;

    @Autowired
    public HolidayEndpoint(HumanResourceService humanResourceService)
            throws JDOMException {
        System.out.println("Hallo, misschien111?");
        this.humanResourceService = humanResourceService;

       // Namespace namespace = Namespace.getNamespace("spring", NAMESPACE_URI);

        //startDateExpression = XPath.newInstance("//StartDate");
        //startDateExpression.addNamespace(namespace);

       // endDateExpression = XPath.newInstance("//EndDate");
        //endDateExpression.addNamespace(namespace);

        //nameExpression = XPath.newInstance("concat(//FirstName,' ',//LastName)");
        //nameExpression.addNamespace(namespace);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetDateSuggestion")
    public void handleHolidayRequest(@RequestPayload Element holidayRequest)
            throws Exception {
        System.out.println("Hallo, misschien?");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = dateFormat.parse("2012-01-01");
        Date endDate = dateFormat.parse("2012-01-01");
        String name = "derp";

        humanResourceService.bookHoliday(startDate, endDate, name);
    }

}