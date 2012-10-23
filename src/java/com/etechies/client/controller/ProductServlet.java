/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etechies.client.controller;


import com.etechies.server.ws.prodcat.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
//This class is used to display Products(CD) based on the Category.
public class ProductServlet extends HttpServlet {

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
        
        List <Product> cat = null;
        String type=null;
        try {
           
            type=request.getParameter("category");
            if(type.equals("all"))
            {
            cat=ProductServlet.getProductList(null);
        }
            else{
               cat=ProductServlet.getProductList(type); 
            }
          
             request.setAttribute("prod", cat);
             RequestDispatcher rd=request.getRequestDispatcher("/productsByCategory.jsp");
             rd.forward(request, response);
        } finally {            
            
         
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



//    private static java.util.List<com.etechies.server.ws.prodcat.Product> getProductList(java.lang.String categoryId) {
//        com.etechies.server.ws.prodcat.ProductCatalogWebService_Service service = new com.etechies.server.ws.prodcat.ProductCatalogWebService_Service();
//        com.etechies.server.ws.prodcat.ProductCatalogWebService port = service.getProductCatalogWebServicePort();
//        return port.getProductList(categoryId);
//    }

    private static java.util.List<com.etechies.server.ws.prodcat.Product> getProductList(java.lang.String categoryId) {
        com.etechies.server.ws.prodcat.ProductCatalogWebService_Service service = new com.etechies.server.ws.prodcat.ProductCatalogWebService_Service();
        com.etechies.server.ws.prodcat.ProductCatalogWebService port = service.getProductCatalogWebServicePort();
        return port.getProductList(categoryId);
    }

  
    
    

 
}
