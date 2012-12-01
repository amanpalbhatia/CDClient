/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etechies.client.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**    
 *
 * @author Aman
 */
@WebServlet(name = "Internationalise", urlPatterns = {"/Internationalise"})
public class Internationalise extends HttpServlet {

    /**  
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession usession;
             Locale currentLocale;
              ResourceBundle messages;
        try {
            /* TODO output your page here. You may use following sample code. */
            
           //SessionController sc= new SessionController(request);
           usession=request.getSession();
            String country = request.getParameter("country").toString();
             String language = request.getParameter("lang").toString();
              currentLocale = new Locale(language,country);

        messages = ResourceBundle.getBundle("Message", currentLocale);
       usession.setAttribute("MESSAGES", messages);
       RequestDispatcher rs= request.getRequestDispatcher("index.jsp");
            rs.forward(request, response);
       
           // out.println(messages.getString("thanks"));
            
           //ResourceBundle rs= (ResourceBundle) usession.getAttribute("MESSAGES");
            //String referer=request.getHeader("referer").toString();
            //referer=referer.substring(0, referer.length()-1);
            //int indexStrt=referer.lastIndexOf('/');
            //int indexEnd=referer.length()-1;
            //String path=referer.substring(indexStrt);
           //out.println(path);
           //out.println(indexEnd);
           
            
        } finally {             
            out.close();
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
}
