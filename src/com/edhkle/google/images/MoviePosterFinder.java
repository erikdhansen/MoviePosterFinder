/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edhkle.google.images;

import java.net.URLDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ehansen
 */
public class MoviePosterFinder {
    final static Logger log = LoggerFactory.getLogger(MoviePosterFinder.class.getName());
    public MoviePosterFinder() {
        
    }
    
    public void search(String queryString) throws Exception {
        GoogleSearchRequest req = new GoogleSearchRequest();
        req.getStandardOptions().setQueryString(queryString);
        req.execute();
    }
    public static void usage() {
        System.out.println("usage: " + MoviePosterFinder.class.getSimpleName() + " <movie keywords>");
    }

/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
        if(args.length < 1) {
            usage();
        }
        StringBuilder sb = new StringBuilder();
        for(String arg : args) {
            sb.append(arg);
        }
        String queryString = URLDecoder.decode(sb.toString(), "UTF-8");
        MoviePosterFinder finder = new MoviePosterFinder();
        finder.search(queryString);
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
}
