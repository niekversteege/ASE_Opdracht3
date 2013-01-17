/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.han.minor.ase.dare2date.maps.service.impl;

import java.net.URI;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import nl.han.minor.ase.dare2date.maps.MapLocation;
import nl.han.minor.ase.dare2date.maps.service.MapsService;
import nl.han.minor.ase.dare2date.profileservice.ProfileService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Niek
 */
public class MapsServiceImpl implements MapsService {

    private final Logger log = Logger.getLogger(this.getClass().getName());
    
    @Autowired
    private ProfileService profileService;
    
    private static final String UNKNOWN = "Unknown";
    private static final String NOKIA_APP_ID = "4FK7DX8Tl9fQS6czRnUw";
    private static final String NOKIA_TOKEN = "KBYlzoAUfx9hVRsedNC1rQ";
    private static final String NOKIA_MAPS_URL = "http://demo.places.nlp.nokia.com/discover/explore?app_id=" + NOKIA_APP_ID + "&app_code=" + NOKIA_TOKEN;
    private static final String YAHOO_URL = "http://where.yahooapis.com/geocode?locale=en_US&flags=&offset=15&gflags=R&start=0&count=100&q=";

    @Override
    public MapLocation getLocation(int userId, int inviteeId) {
        double latitude,longitude,lat1,lat2,long1,long2;
        MapLocation user = profileService.getAddress(userId);
        MapLocation invitee = profileService.getAddress(inviteeId);
        org.w3c.dom.Document d = getYahooLocation(user);
        
        lat1 = Double.parseDouble( d.getElementsByTagName("latitude").item(0).getTextContent());
        long1 = Double.parseDouble( d.getElementsByTagName("longitude").item(0).getTextContent());
        
        d = getYahooLocation(invitee);
        
        lat2 = Double.parseDouble( d.getElementsByTagName("latitude").item(0).getTextContent());
        long2 = Double.parseDouble( d.getElementsByTagName("longitude").item(0).getTextContent());
        
        latitude = (lat1+lat2)/2;
        longitude = (long1+long2)/2;
        
        d = getYahooLocation(latitude, longitude);
        String result = d.getElementsByTagName("city").item(0).getTextContent();
        
        // TODO: find usable address based on these two.
        
        MapLocation location = new MapLocation(result, UNKNOWN, UNKNOWN, ""+latitude , ""+longitude);
        
        return location;
    }
    public org.w3c.dom.Document getYahooLocation(MapLocation m){
        try{
            URI uri = new URI(
                    "http",
                    "where.yahooapis.com",
                    "/geocode?locale=en_US&flags=&offset=15&gflags=R&start=0&count=100&q="+m.getStreet()+" "+m.getNumber()+" "+m.getTown(),
                    null
                    );
            String url = uri.toString();
            log.debug("REQUESTURL\n"+url);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(url);
        }
        catch(Exception e){
            
        }
        return null;
    }
    public org.w3c.dom.Document getYahooLocation(double latitude, double longitude){
        try{
            URI uri = new URI(
                    "http",
                    "where.yahooapis.com",
                    "/geocode?locale=en_US&flags=&offset=15&gflags=R&start=0&count=100&q="+latitude+", "+longitude,
                    null
                    );
            String url = uri.toString();
            log.debug("REQUESTURL\n"+url);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(url);
        }
        catch(Exception e){
            
        }
        return null;
    }
}
