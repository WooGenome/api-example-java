package com.nodexy.genome.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nodexy.genome.api.UserApi;
import com.nodexy.genome.session.SessionTokenStore;

/**
 * Servlet implementation class ApiServlet
 */
@WebServlet("/api")
public class ApiServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String apiName = request.getParameter("apiName");
        String data = request.getParameter("data");

        StringBuffer res = new StringBuffer();
        if ("/user".equals(apiName)) {
            String accessToken = SessionTokenStore.get(
                    request.getSession().getId()).getAccessToken();
            UserApi userApi = new UserApi(accessToken);

            String user = userApi.getUser();
            res.append(user);
        } else if ("/names".equals(apiName)) {
            // TODO 
            
            
            
            
        } else {
            res.append("{'error':'unknown apiName[" + apiName + "]'}");
        }
        response.getWriter().write(res.toString());
        response.getWriter().flush();
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
