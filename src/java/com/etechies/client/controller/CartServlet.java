/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etechies.client.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.etechies.client.controller.SessionController;
import com.etechies.server.ws.prodcat.Product;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Aman
 */

//This Class is invloved in all the activites related to Shopping Cart.
public class CartServlet extends HttpServlet {

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
        String cd=null;
        String action=null;
        String forward=null;
        ArrayList<Product> cart= new ArrayList<Product>();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           SessionController sc= new SessionController(request);
           usession=sc.getSession(request);
           cd=request.getParameter("cdId");
           action=request.getParameter("action");
           //Add item to cart start
            if (!cd.isEmpty()) {
                //Add item to cart -- start
                if (action.equals("add")) {
                    Product item = CartServlet.getProductInfo(cd);
                    cart = sc.addToCart(item);
                    forward="ProductsByCategory?category="+item.getCategory();
                    String msg= "Item added to Cart : "+item.getTitle();
                    request.setAttribute("cartmsg", msg);
                } 
                //Add item to cart -- End
                //Remove item from cart -- start
                else {
                   // out.println(sc.getCartItems().size());
                    cart=sc.removeItemFromCart(cd);
                    forward="/cart.jsp";
                    request.setAttribute("cartmsg", "Item removed from cart");
                }//Remove item from cart -- End
            }
             else {
                forward="/index.jsp";
                request.setAttribute("msg", "Requested Action Cannot be performed");
            }
            RequestDispatcher rs= request.getRequestDispatcher(forward);
            rs.forward(request, response);
           
           }
           
         finally {            
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

    private static Product getProductInfo(java.lang.String productId) {
        com.etechies.server.ws.prodcat.ProductCatalogWebService_Service service = new com.etechies.server.ws.prodcat.ProductCatalogWebService_Service();
        com.etechies.server.ws.prodcat.ProductCatalogWebService port = service.getProductCatalogWebServicePort();
        return port.getProductInfo(productId);
    }
}
