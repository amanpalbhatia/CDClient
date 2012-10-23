/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etechies.client.controller;

import com.etechies.server.ws.orderproc.POrder;
import com.etechies.server.ws.orderproc.Product;
import java.io.IOException;
import java.io.PrintWriter;
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
//This class handles all the activities related to Order.
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
        HttpSession usession = null;
        String forward = null;
        ArrayList<com.etechies.server.ws.prodcat.Product> prodCart = new ArrayList<com.etechies.server.ws.prodcat.Product>();
        ArrayList<Product> ordCart = new ArrayList<Product>();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            SessionController sc = new SessionController(request);
            //Confirm order -- start
            if (request.getParameter("fldConfrmOrder") != null) {
                if (sc.getOrderNo()==5){//checks if it is more than fifth order in a session.
                    forward = "index.jsp";
                    request.setAttribute("confirmOrderMsg", "Purchase limit exceeded");
                    RequestDispatcher rd = request.getRequestDispatcher(forward);
                rd.forward(request, response);
                }
                else{//It less than fifth order in a session
                if (request.getParameter("cardNumber") != null) {
                    boolean confirmed = false;
                    ArrayList<POrder> ol = sc.getOrderList();
                    if (ol != null) {
                        int poid = ol.get(ol.size() - 1).getOrderId();
                        confirmed = OrderServlet.confirmOrder(poid, true);
                    }
                    if (confirmed) {//order is approved
                        int i = 0;
                        i = sc.getOrderNo();
                        i++;
                        sc.setOrderNo(i);
                        sc.emptyCart();
                        request.setAttribute("confirmOrderMsg", "Order Confirmed!");
                    } else {//order is not processed
                        request.setAttribute("confirmOrderMsg", "Order cannot be completed!");
                    }
                    forward = "index.jsp";
                    //request.setAttribute("confirmOrderMsg", "Enter your Credit Card Details");
                } else {//Missing Credit card Info
                    forward = "checkout.jsp";
                    request.setAttribute("confirmOrderMsg", "Enter your Credit Card Details");
                }
                RequestDispatcher rd = request.getRequestDispatcher(forward);
                rd.forward(request, response);}
            }//Confirm order -- End
            //Create order -- start
            else{

            if (sc.isUserLoggedIn()) {
                forward = ("/checkout.jsp");
                prodCart = sc.getCartItems();

                int uid = sc.getLoggedUser().getUserId();
                // out.println(prodCart.size());
                if (prodCart != null) {//atleast 1 item is in Shopping Cart.

                    float total = 0;

                    for (com.etechies.server.ws.prodcat.Product product : prodCart) {
                        Product order = new Product();
                        //out.println("size:");
                        order.setCdId(product.getCdId());
                        // out.println(uid);

                        order.setCategory(product.getCategory());
                        //product.getCdId()
                        order.setPrice(product.getPrice());
                        order.setTitle(product.getTitle());
                        ordCart.add(order);
                        total += product.getPrice();
                    }
                    sc.setOrderTotal(total);
//                    for (Product product : ordCart) {
//                    out.println(product.getCdId());
//                    out.println(product.getPrice());
//                    out.println(product.getTitle());
//                    }

                    // out.println("size:");
                    //out.println(ordCart.size());
                    POrder order = OrderServlet.createOrder(uid, ordCart);
                    sc.setOrder(order);
                    ArrayList<POrder> orderList = sc.addToOrderList(order);
                    sc.setOrderList(orderList);



                    request.setAttribute("chkoutmsg", "Confirm order to complete process.");

                    forward = "/checkout.jsp";
                } else {//no items in Shopping Cart
                    //out.println("size1:");
                    request.setAttribute("chkoutmsg", "Select Items before you Check Out");
                    forward = "/index.jsp";
                }


            } else {//User Not loggedin

                // out.println("size2:");
                forward = "/login.jsp";
                request.setAttribute("chkoutmsg", "Login before you Check Out");

            }//Create order -- End
            RequestDispatcher rd = request.getRequestDispatcher(forward);
            rd.forward(request, response);

        } }finally {
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

    private static POrder createOrder(int userId, java.util.List<com.etechies.server.ws.orderproc.Product> cart) {
        com.etechies.server.ws.orderproc.OrderProcessWebService_Service service = new com.etechies.server.ws.orderproc.OrderProcessWebService_Service();
        com.etechies.server.ws.orderproc.OrderProcessWebService port = service.getOrderProcessWebServicePort();
        return port.createOrder(userId, cart);
    }

    private static boolean confirmOrder(int orderId, boolean paymentInfo) {
        com.etechies.server.ws.orderproc.OrderProcessWebService_Service service = new com.etechies.server.ws.orderproc.OrderProcessWebService_Service();
        com.etechies.server.ws.orderproc.OrderProcessWebService port = service.getOrderProcessWebServicePort();
        return port.confirmOrder(orderId, paymentInfo);
    }
}
