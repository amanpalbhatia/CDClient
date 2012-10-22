/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etechies.client.controller;

import com.etechies.server.ws.orderproc.Account;
import com.etechies.server.ws.orderproc.POrder;
import com.etechies.server.ws.prodcat.Product;
import java.io.IOException;
import java.util.ArrayList;
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
public class SessionController extends HttpServlet {
    

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
    HttpServletRequest pageRequest = null;
    HttpSession session = null;
    String USERINFO="USERINFO";
    String CARTITEMS="CARTITEMS";
    String ORDERLIST="ORDERLIST";
    String ORDERINFO="ORDERINFO";
    String ORDERNO="ORDERNO";
    String ORDERTOTAL="ORDERTOTAL";

    public SessionController(HttpServletRequest httpRequest) {
        this.pageRequest = httpRequest;
        session = httpRequest.getSession();
        
    }

    public HttpSession getSession(HttpServletRequest httpRequest) {
        if (session == null) {
            session = httpRequest.getSession();
        }
        return session;
    }

    public void setLoggedUser(Account userInfo) {
        session.setAttribute(USERINFO, userInfo);
    }

    public Account getLoggedUser() {
        //getSession();
        return (Account) session.getAttribute(USERINFO);
    }

    public boolean isUserLoggedIn() {
        Account loggedUser = null;
        boolean exception = false;
        if (session != null) {
            try {
                loggedUser = (Account) session.getAttribute(USERINFO);
            } catch (Exception ex) {
                exception = true;
                ex.printStackTrace();
            }
            if (loggedUser == null || exception == true) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    public ArrayList<Product> setCartItems(ArrayList<Product> cartItems) {
        session.setAttribute(CARTITEMS, cartItems);
        return getCartItems();
    }

    public ArrayList<Product> getCartItems() {
        ArrayList<Product> cartItems = (ArrayList<Product>) session.getAttribute(CARTITEMS);
        return cartItems;
    }

    public ArrayList<Product> addToCart(Product newItem) {
        ArrayList<Product> currentCart = getCartItems();
        if (currentCart == null) {
            currentCart = new ArrayList<Product>();
        }
        currentCart.add(newItem);
        setCartItems(currentCart);

        currentCart = getCartItems();
        return currentCart;
    }
    public void emptyCart(){
        session.setAttribute(CARTITEMS, null);
    }
//
//    public ArrayList<Product> removeItemFromCart(Product itemToRemove) {
//        String searchItemId = itemToRemove.getCdId();
//
//        ArrayList<Product> currentCart = removeItemFromCart(searchItemId);
//
//        return currentCart;
//    }
//
    public ArrayList<Product> removeItemFromCart(String itemId) {
        ArrayList<Product> currentCart = getCartItems();

        if (currentCart == null) {
            currentCart = new ArrayList<Product>();
            return currentCart;
        }

        int indexToDelete =-1;
        for (int i = 0; i < currentCart.size(); i++) {
            if (currentCart.get(i).getCdId().equals(itemId)) {
                indexToDelete=i;
                break;
            }
        }
        currentCart.remove(indexToDelete);
        setCartItems(currentCart);
        
        return currentCart;
    }
public void setOrder(POrder order)
{
    session.setAttribute(ORDERINFO, order);
    
}

public POrder getOrder()
{
     return (POrder)session.getAttribute(ORDERINFO);
}
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
        
        try {
          HttpSession usersession = getSession(request);
         // setLoggedUser();
       Account cat = SessionController.getAccountInfo("abhat");
             //Product cat=SessionController.getProductList("pop").get(1);
             request.setAttribute("prod", cat);
             RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
             rd.forward(request, response);
        } finally {            
            
            //out.close();
        }
    }
    public void setOrderNo(int count){
        session.setAttribute(ORDERNO, count);
    }
    public int getOrderNo(){
        if(session.getAttribute(ORDERNO)==null) {
            return 0;
        }
        return (Integer) session.getAttribute(ORDERNO);
    }
    public void setOrderTotal(float amt){
        session.setAttribute(ORDERTOTAL, amt);
    }
    public Float getOrderTotal(){
        return (Float) session.getAttribute(ORDERTOTAL);
    }
    
    public void setOrderList(ArrayList<POrder> ord){
        session.setAttribute(ORDERLIST, ord);
            }
    public ArrayList<POrder> getOrderList()
    {
        return (ArrayList<POrder>) session.getAttribute(ORDERLIST);
    }
    
    public ArrayList<POrder> addToOrderList(POrder order){
         ArrayList<POrder> currentOrderList = getOrderList();
        if (currentOrderList == null) {
            currentOrderList = new ArrayList<POrder>();
        }
        currentOrderList.add(order);
        setOrderList(currentOrderList);

        currentOrderList = getOrderList();
        return currentOrderList;
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

    private static java.util.List<java.lang.String> getCategoryList() {
        com.etechies.server.ws.prodcat.ProductCatalogWebService_Service service = new com.etechies.server.ws.prodcat.ProductCatalogWebService_Service();
        com.etechies.server.ws.prodcat.ProductCatalogWebService port = service.getProductCatalogWebServicePort();
        return port.getCategoryList();
    }

    private static java.util.List<com.etechies.server.ws.prodcat.Product> getProductList(java.lang.String categoryId) {
        com.etechies.server.ws.prodcat.ProductCatalogWebService_Service service = new com.etechies.server.ws.prodcat.ProductCatalogWebService_Service();
        com.etechies.server.ws.prodcat.ProductCatalogWebService port = service.getProductCatalogWebServicePort();
        return port.getProductList(categoryId);
    }

    private static Account getAccountInfo(java.lang.String uname) {
        com.etechies.server.ws.orderproc.OrderProcessWebService_Service service = new com.etechies.server.ws.orderproc.OrderProcessWebService_Service();
        com.etechies.server.ws.orderproc.OrderProcessWebService port = service.getOrderProcessWebServicePort();
        return port.getAccountInfo(uname);
    }
}
