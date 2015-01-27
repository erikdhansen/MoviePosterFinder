/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edhkle.google.images;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ehansen
 */
public class GoogleSearchRequest {
    public final static Logger log = LoggerFactory.getLogger(GoogleSearchRequest.class.getName());
    
    public static final String BASE_URL = "http://ajax.googleapis.com/ajax/services/search/images";    
    
    StandardGoogleOptions stdOpts = new StandardGoogleOptions();
    OptionalGoogleOptions optOpts = new OptionalGoogleOptions();
    List<String> results = new LinkedList<>();
    
    public GoogleSearchRequest() {
        
    }
    
    public StandardGoogleOptions getStandardOptions() {
        return stdOpts;
    }
    
    public OptionalGoogleOptions getOptionalOptions() {
        return optOpts;
    }
    
    public List<String> getSearchResults() {
        return results;
    }
    
    public List<String> execute() throws MalformedURLException, IOException {
        // Execute the search, populate the results and return them
        String queryURL = BASE_URL.concat("?").concat(stdOpts.getOptionString());
        if(getOptionalOptions().hasOptional()) {
            queryURL = queryURL.concat(optOpts.getOptionString());
        }
        URL url = new URL(queryURL);
        log.info("Opening network connection: " + url.toString() + "\n");
        URLConnection connection = url.openConnection();
        connection.addRequestProperty("Referer", "http://www.edhkle.com");
        
        connection.setDoOutput(true);
        // OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
        // writer.close();
        
            String line;
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while((line = reader.readLine()) != null) {
                builder.append(line);
            }
            JSONObject json = new JSONObject(builder.toString());
            log.info("\n***************************************************************\nReceived Response\n***************************************************************\n" + json.toString(3) + "\n***************************************************************\n");
        return getSearchResults();
    }
}
