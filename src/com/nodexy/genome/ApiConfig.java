package com.nodexy.genome;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApiConfig {

    public static final String CLIENT_ID ;
    public static final String CLIENT_SECRET ;
    public static final String REDIRECT_URI ;

    public static final String API_ENDPOINT_URL ;
    public static final String API_ENDPOINT_URL_DEMO ;

    static {
        Properties pps = new Properties();
        InputStream in =  Thread.currentThread().getContextClassLoader().getResourceAsStream("config/23andme.api.properties");
        try {
            pps.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        CLIENT_ID = pps.getProperty("CLIENT_ID");
        CLIENT_SECRET = pps.getProperty("CLIENT_SECRET");
        REDIRECT_URI = pps.getProperty("REDIRECT_URI");
        API_ENDPOINT_URL = pps.getProperty("API_ENDPOINT_URL");
        API_ENDPOINT_URL_DEMO = pps.getProperty("API_ENDPOINT_URL_DEMO");
    }
}
