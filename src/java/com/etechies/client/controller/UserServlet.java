/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etechies.client.controller;

import com.etechies.server.ws.orderproc.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.etechies.client.controller.SessionController;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author Aman
 */
//This Class is used to register new User and Authenticating the existing user.
public class UserServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     */
    HttpSession usession=null;
    String uname=null;
    String upwd=null;
    String  forward=null;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            SessionController sc=new SessionController(request);
            String registermsg=null;
            /* TODO output your page here. You may use following sample code. */
            if(request.getParameter("register")!=null){//Register new User
                String uname=request.getParameter("uname");
               // out.println(uname);
                String upwd=request.getParameter("pwd");
                String ufname=request.getParameter("fname");
                String ulname=request.getParameter("lname");
                String ustreet=request.getParameter("street");
                String uprovince=request.getParameter("province");
                String ucountry=request.getParameter("country");
                String uzip=request.getParameter("zip");
                String uphone=request.getParameter("phone");
                
           registermsg = UserServlet.createAccount(uname, upwd, ulname,ufname, ustreet, uprovince, ucountry, uzip, uphone);
          out.println(registermsg);
           if (registermsg.equals("Account succesfully created")){
                forward="index.jsp";
            }
            else{forward="register.jsp";
            }
//            RequestDispatcher rd = request.getRequestDispatcher(forward);
//            rd.forward(request,response);
            }
            else{//Authenticating existing User (Log in)
            usession=sc.getSession(request);
            uname=request.getParameter("username");
            if (!uname.isEmpty())
            {upwd=request.getParameter("password");
            Account acc=UserServlet.getAccountInfo(uname);
            if (upwd.equals(acc.getUpassword()))
            {
                sc.setLoggedUser(acc);
              forward = "/index.jsp";
              request.setAttribute("loginmsg", "Login-Success");
            }
            else
            {
                forward= "/login.jsp";
               // request.setAttribute("msg", acc.getUpassword()+" "+acc.getUname());
                 request.setAttribute("loginmsg", "Invalid Username or Password");
            }
            }
            else{
                forward= "/login.jsp";
               // request.setAttribute("msg", acc.getUpassword()+" "+acc.getUname());
                 request.setAttribute("loginmsg", "Invalid Username or Password");
            }
            RequestDispatcher rd = request.getRequestDispatcher(forward);
            rd.forward(request,response);
          //setLoggedUser();
            }
        } finally {            
            //out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private static Account getAccountInfo(java.lang.String uname) {
        com.etechies.server.ws.orderproc.OrderProcessWebService_Service service = new com.etechies.server.ws.orderproc.OrderProcessWebService_Service();
        com.etechies.server.ws.orderproc.OrderProcessWebService port = service.getOrderProcessWebServicePort();
        return port.getAccountInfo(uname);
    }

    private static String createAccount(java.lang.String uname, java.lang.String upassword, java.lang.String fname, java.lang.String lname, java.lang.String street, java.lang.String province, java.lang.String zip, java.lang.String country, java.lang.String phone) {
        com.etechies.server.ws.orderproc.OrderProcessWebService_Service service = new com.etechies.server.ws.orderproc.OrderProcessWebService_Service();
        com.etechies.server.ws.orderproc.OrderProcessWebService port = service.getOrderProcessWebServicePort();
        return port.createAccount(uname, upassword, fname, lname, street, province, zip, country, phone);
    }
}
