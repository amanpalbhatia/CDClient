/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etechies.client.controller;

import com.etechies.server.ws.orderproc.POrder;
import com.etechies.server.ws.orderproc.ShoppingCart;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aman
 */
public class OrderServlet extends HttpServlet {

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
        HttpSession usession=null;
        String forward=null;
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
     try {
         SessionController sc= new SessionController(request);
         
         if(sc.isUserLoggedIn()){
         forward=("/index.jsp");
         ShoppingCart cart= new ShoppingCart();
         
         }
         else{
             forward= "/login.jsp";
                  request.setAttribute("chkoutmsg", "Login before you place order");
         }
         RequestDispatcher rd = request.getRequestDispatcher(forward);
            rd.forward(request,response);
           
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

    private static POrder createOrder(int userId, com.etechies.server.ws.orderproc.ShoppingCart cart) {
        com.etechies.server.ws.orderproc.OrderProcessWebService_Service service = new com.etechies.server.ws.orderproc.OrderProcessWebService_Service();
        com.etechies.server.ws.orderproc.OrderProcessWebService port = service.getOrderProcessWebServicePort();
        return port.createOrder(userId, cart);
    }
}
