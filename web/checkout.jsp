<%-- 
    Document   : checkout
    Created on : Oct 21, 2012, 2:10:11 PM
    Author     : Aman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>e-Techies CD Store</title>
    </head>
    <body>
 <div id="main">
            
            <div id="header">
                  <div id="widgetBar">
                        <div class="headerWidget">
                            [ Sign Out ]
                        </div>
                        

                        <div class="headerWidget">
                            <a href="cart.jsp" >[ View cart ]</a>
                        </div>
                      <div class="headerWidget">
                            <a href="OrderServlet" >[ Check Out ]</a>
                        </div>
                        
                        <div class="headerWidget">
                            <c:choose>
                                <c:when test="${sessionScope.USERINFO == null}">
                            [ login ]
                                </c:when>
                            <c:otherwise>
                                [ Hi, <c:out value="${sessionScope.USERINFO.fname}"/>]
                                </c:otherwise>
                            </c:choose>
                        </div>
                        

                    </div>

                    <a href="#">
                        <img src="images/logo.png" id="logo" alt="Store Logo">
                    </a>

                    <div id="logoText">
                        CSI5380 </br></br>
                        E-Techies  CD Store
                    </div>
                    
                
            </div>  <!-- End of Header -->
            <div id="menu">
                [placeholder]
            </div>
            <!-- Start of content left and right column-->
            <div id="indexLeftColumn">
				<p>PRODUCTS BY:</p>
				<ul id="order">
                                                <li class="categoryBox"> 
							<span class="categoryLabelText"> 
                                                        <a href="ProductsByCategory?category=all"> All</a>
                                                        </span>
						</li>

						<li class="categoryBox"> 
							<span class="categoryLabelText"> 
                                                        <a href="ProductsByCategory?category=country"> Country </a>
                                                        </span>
						</li>
                                                <li class="categoryBox"> 
							<span class="categoryLabelText"> 
                                                        <a href="ProductsByCategory?category=pop"> Pop </a>
                                                        </span>
                                                        
						</li>
                                                <li class="categoryBox"> 
							<span class="categoryLabelText"> 
                                                        <a href="ProductsByCategory?category=Rock"> Rock </a>
                                                        </span>
                                                       
						</li>


					<!--<li class="bold">Category</li>
					<form method="POST"
						  action="Controller"></form>
					<select name="category" size="1">
						
					</select>
					<input type="submit"> 
					<ul>

					</ul> 
					<li class="bold">Price</li>
					<ul>
						<li> Lowest to Highest</li>
						<li> Highest to Lowest</li>
					</ul>

					<li class="bold">Title</li>
					<ul>
						<li> A to Z</li>
						<li> Z to A</li>
					</ul>
				</ul>

				<!--[Placeholder]-->
			</div>


			<div id="indexRightColumn">
				<h2>Check Out - Order</h2>
                              <label class="categoryLabelText"> <c:out value="${confirmOrderMsg}" /></label>

		<div class="orderBox"> 

                        <span class="categoryLabelText"> ORDER ID </span>
                        <span class="categoryLabelText"> USER ID </span>
                        <span class="categoryLabelText"> STATUS </span>
                        <span class="categoryLabelText"> TOTAL </span>
		
                         </br>
                       </div>
                <div class="orderBox"> 
                    <c:forEach items="${sessionScope.ORDERLIST}" var="temp">
                    <span class="categoryLabelText"> ${temp.orderId}</span>
                        <span class="categoryLabelText">${temp.userId}</span>
                        <span class="categoryLabelText">${temp.status} </span>
                                                </br>

                       </c:forEach>
                      </div>        </br>
                      Provide payment: </br>
                      OrderId : <span class="categoryLabelText"><c:out value=" ${sessionScope.ORDERINFO.orderId}"/></span></br>
                      Items : <c:forEach items="${sessionScope.CARTITEMS}" var="temp">
                          <span class="categoryLabelText"> ${temp.title}</span>
                        <span class="categoryLabelText">${temp.category}</span>
                        <span class="categoryLabelText">${temp.price} </span>
                        </br>
                      </c:forEach>
                        </br>
                      
                        Total : <c:out value="${sessionScope.ORDERTOTAL}"/>
                        </br>
                      <form name="confirmOrder" action="OrderServlet">
                          <label>Card Number:</label>  <input type="text" name="cardNumber"/></br>
                          <label>Card Type:</label>  <select>
  <option value="visa">VISA</option>
  <option value="mc">Master Card</option>
  <option value="debit">INTERAC</option>
  </select></br>
                                         <label>Expiry : </label> <label>Year:</label> <select>
  <option value="12">2012</option>
  <option value="13">2013</option>
  <option value="14">2014</option>
  </select>
                                         <label>Month:</label> <select>
  <option value="1">JAN</option>
  <option value="2">FEB</option>
  <option value="3">MAR</option>
  <option value="1">APR</option>
  <option value="2">MAY</option>
  <option value="3">JUN</option>
  <option value="1">JUL</option>
  <option value="2">AUG</option>
  <option value="3">SEP</option>
  <option value="1">OCT</option>
  <option value="2">NOV</option>
  <option value="3">DEC</option>
  
  </select>
                                         <input type="hidden" name="fldConfrmOrder" value="confirmOrder">
                                         </br>  <input type="submit" value="Confirm Order">        
                      </form>
                      </div>
                


            </div>


			
                        
                   <!-- End of content left and right column-->
			<div id="footer">
                            <hr>
                            <p id="footerText">[ footer text ]</p>
			</div>
		   </body>
</html>

