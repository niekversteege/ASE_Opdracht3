/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.han.minor.ase.dare2date.nokiamaps.service.impl;

import nl.han.minor.ase.dare2date.nokiamaps.service.NokiaMapsService;
import org.apache.log4j.Logger;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Niek
 */
public class NokiaMapsServiceImpl implements NokiaMapsService {

    private final Logger log = Logger.getLogger(this.getClass().getName());
    private static final String MAPS_URL = "http://demo.places.nlp.nokia.com/discover/explore";

    @Override
    public String getLocation() {

        RestTemplate restTemplate = new RestTemplate();
        String response = null;
        
        //response = restTemplate.getForObject(MAPS_URL, String.class);

        log.debug("Nokia maps response: \n" + response);

        return response;
    }
}
