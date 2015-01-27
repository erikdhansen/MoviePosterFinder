/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edhkle.google.images;

import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * @author ehansen
 */
public class StandardGoogleOptions {
    final static Logger log = LoggerFactory.getLogger(StandardGoogleOptions.class);
    
    private Map<String,String> oMap = new HashMap<>();

    public StandardGoogleOptions() {
        oMap.put("q", "");
        oMap.put("v", "1.0");
        oMap.put("userip", "172.16.1.100");        
    }
    
    public String getOptionString() throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        sb.append("v=").append(oMap.get("v")).append("&q=").
        append(URLEncoder.encode(oMap.get("q"), "UTF-8")).append("&userip=").
        append(oMap.get("userip"));
        return sb.toString();
    }
    
    public String getOption(String key) {
        return oMap.get(key);
    }
    
    public String getQueryString() {
        return oMap.get("q");
    }

    public void setQueryString(String queryString) {
        oMap.put("q", queryString);
    }
    
    public String getVersion() {
        return oMap.get("v");
    }
    
    public void setVersion(String version) {
        oMap.put("v", version);
    }
    
    public String getUserIP() {
        return oMap.get("userip");
    }
    
    public void setUserIP(String userIP) throws UnknownHostException {
        String[] bytes = userIP.split(".");
        byte[] ipv4 = new byte[4];
        for(int i=0; i < bytes.length; i++) {
            byte b = Byte.parseByte(bytes[i]);
            if(!((b >= 0) && (b <= 255))) {
                throw new IllegalArgumentException("Invalid IP address: " + userIP);
            } else {
                ipv4[i] = b;
            }
        }
        Inet4Address.getByAddress(ipv4);
        oMap.put("userip", userIP);
    }

    public static String localIPAddress() {
        String ipv4 = "";
        try {
        byte[] ipBytes = Inet4Address.getLocalHost().getAddress();
        StringBuilder ip = new StringBuilder();
        for(int i=0; i < ipBytes.length; i++) {
            ip.append(String.valueOf(ipBytes[i])).append(".");
        }
        ipv4 = ip.toString().substring(0, ip.toString().lastIndexOf("."));
        } catch (UnknownHostException e) {
            log.error(e.getClass().getName(), e);
        }
        log.info("Found and returned IP Address: " + ipv4);
        return ipv4;
    }
}
