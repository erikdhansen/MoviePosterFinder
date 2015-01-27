/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edhkle.google.images;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ehansen
 */
public class OptionalGoogleOptions {
    final static Logger log = LoggerFactory.getLogger(OptionalGoogleOptions.class.getName());

    Map<String,String> options = new HashMap<>();
    {
        options.put("as_filetype", null);
        options.put("as_rights", null);
        options.put("as_sitesearch", null);
        options.put("as_callback", null);
        options.put("context", null);
        options.put("hl", null);
        options.put("imgc", null);
        options.put("imgcolor", null);
        options.put("imgsz", null);
        options.put("imgtype", null);
        options.put("restrict", null);
        options.put("rsz", null);
        options.put("safe", null);
        options.put("start", null);
    }

    public OptionalGoogleOptions() {
        
    }

    public String getOptionString() {
        String optionString = "";
        if(!hasOptional()) {
            return optionString;
        }
        StringBuilder sb = new StringBuilder();
        for(String key : options.keySet()) {
            if(options.get(key) != null) {
                sb.append("&").append(key).append("=").append(options.get(key));
            }
        }
        try {
            optionString = URLEncoder.encode(sb.toString(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error("UnsupportedEncodingException trying to encode optionString: " + sb.toString(), e);
        }
        return optionString;
    }
    
    public boolean hasOptional() {
        boolean hasOptions = false;
        for(String value : options.values()) {
            if(options.get(value) != null) {
                hasOptions = true;
                break;
            }
        }
        return hasOptions;
    }
    
    public void setOption(String optionName, String optionValue) {
        if(!options.containsKey(optionName)) {
            throw new IllegalArgumentException("No such option: " + optionName);
        }
        options.put(optionName, optionValue);
    }
}
