package com.nodexy.genome.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nodexy.genome.ApiConfig;
import com.nodexy.genome.session.SessionToken;
import com.nodexy.genome.session.SessionTokenStore;

/**
 * Servlet implementation class ReceiveCodeServlet
 */
@WebServlet("/receive_code/")
public class ReceiveCodeServlet extends HttpServlet {

    private static final long serialVersionUID = -3927178781192069160L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiveCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        
        System.out.println("code: " + code);
        
        if(code==null || code.trim().length()<4){
            response.sendError(500, "authorize error: [code=" + code +", msg=" 
                       + request.getParameter("error") + request.getParameter("error_description") +"]");
            return ;
        }
        
        HttpsURLConnection conn = (HttpsURLConnection)new URL(ApiConfig.ACCESS_TOKEN_URL).openConnection();
        conn.setUseCaches(false); 
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST"); 
        conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("user-agent",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        
        OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
        out.write(String.format("client_id=%s&client_secret=%s&grant_type=authorization_code&code=%s&redirect_uri=%s&scope=basic"
                ,ApiConfig.CLIENT_ID,ApiConfig.CLIENT_SECRET,code,ApiConfig.REDIRECT_URI));
        out.flush();  
        out.close();// XXX
        
        try {
            Thread.sleep(10);// FIXME 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        if(conn.getResponseCode()!=200){
            response.sendError(500, "token error: [response=" + conn.getResponseCode()+" " +conn.getResponseMessage() +"]");
            return ;
        } 
        
        BufferedReader in = new BufferedReader(new InputStreamReader( conn.getInputStream()));  
        String encoding = conn.getContentEncoding();  
        StringBuffer body = new StringBuffer();
        String line = in.readLine();
        while(true){
            if (line==null){
                break;
            }else{
                body.append(line);
                line = in.readLine();
            }
        }
        System.out.println("body: "+body.toString());
        String json = body.toString();//new String(body.toString().getBytes(encoding)); 
        
        System.out.println("response: " + json);
        
        String[] kvs = json.substring(1, json.length()-2).split(",");
        Map<String,String> m = new HashMap<String,String>();
        String [] k = null;
        for(String kv: kvs){
            k = kv.split(":");
            m.put(k[0], k[1]);
        }
        
        HttpSession session = request.getSession();
        SessionTokenStore.add(session.getId(), new SessionToken(m.get("access_token")
                , m.get("token_type"), m.get("expires_in"), m.get("refresh_token"), m.get("scope")));
        
        response.sendRedirect("./main.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

}
