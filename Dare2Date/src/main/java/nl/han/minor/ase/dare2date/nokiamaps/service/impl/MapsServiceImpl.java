/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.han.minor.ase.dare2date.nokiamaps.service.impl;

import java.util.ArrayList;
import java.util.List;
import nl.han.minor.ase.dare2date.nokiamaps.service.MapsService;
import org.apache.log4j.Logger;
import org.springframework.http.client.CommonsClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Niek
 */
public class MapsServiceImpl implements MapsService {

    private final Logger log = Logger.getLogger(this.getClass().getName());
    
    private static final String NOKIA_APP_ID = "4FK7DX8Tl9fQS6czRnUw";
    
    private static final String NOKIA_TOKEN = "KBYlzoAUfx9hVRsedNC1rQ";
    
    private static final String NOKIA_MAPS_URL = "http://demo.places.nlp.nokia.com/discover/explore?app_id=" + NOKIA_APP_ID + "&app_code=" + NOKIA_TOKEN;

    @Override
    public String getLocation() {

        String response = null;

        

        return response;
    }
}
