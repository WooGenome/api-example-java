package com.nodexy.genome.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HttpUtil {

    public static String get(String url, String accessToken) {
        return post(url, accessToken, null);
    }
    
    public static String put(String url, String accessToken,String params) {
        return post(url, accessToken, params); // TODO
    }
    
    public static String patch(String url, String accessToken,String params) {
        return post(url, accessToken, params); // TODO
    }

    public static String post(String url, String accessToken, String params) {
        PrintWriter out = null;
        BufferedReader in = null;
        StringBuffer result = new StringBuffer();
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();

            conn.setConnectTimeout(30000); // ms
            conn.setReadTimeout(15000); // ms

            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Authorization", "Bearer " + accessToken);
            
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            //conn.setRequestProperty("myheader", "xxxxx"); // for test
            
            
            // for test
            System.out
                    .println("REQUEST ===========================================");
            Map<String, List<String>> map1 = conn.getRequestProperties();
            for (String key : map1.keySet()) {
                System.out.println(key + ":" + map1.get(key));
            }
            System.out.println("");

            if (params == null) {
                conn.connect();
            } else {
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setUseCaches(false);

                out = new PrintWriter(conn.getOutputStream());
                out.print(params);
                out.flush();
                out.close();
            }

            // for test
            System.out
                    .println("RESPONSE ===========================================");
            Map<String, List<String>> map = conn.getHeaderFields();
            for (String key : map.keySet()) {
                System.out.println(key + ":" + map.get(key));
            }
            System.out.println("");

            // response
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            System.out.println("HTTP error: " + e); // FIXME
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result.toString();
    }
}
