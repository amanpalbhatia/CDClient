<%-- 
    Document   : checkout
    Created on : Oct 21, 2012, 2:10:11 PM
    Author     : Aman
--%>

<%@ include file="/jspf/header.jspf" %> 
<%@ include file="/jspf/leftsidebar.jspf" %> 

<%@page contentType="text/html" pageEncoding="UTF-8"%>

			<div id="indexRightColumn">
				<h2><c:out value="${sessionScope.MESSAGES.Check_Out_Order}" /></h2>
                                 <label class="categoryLabelText"> <c:out value="${confirmOrderMsg}" /></label>

		<div class="orderBox"> 

                        <span class="categoryLabelText"> <c:out value="${sessionScope.MESSAGES.ORDER_ID}" /> </span>
                        <span class="categoryLabelText"> <c:out value="${sessionScope.MESSAGES.USER_ID}" /> </span>
                        <span class="categoryLabelText"> <c:out value="${sessionScope.MESSAGES.STATUS}" /> </span>
                        <span class="categoryLabelText"> <c:out value="${sessionScope.MESSAGES.TOTAL}" /> </span>
		
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
                      <c:out value="${sessionScope.MESSAGES.Provide_payment}" />: </br>
                      <c:out value="${sessionScope.MESSAGES.ORDER_ID}" />: <span class="categoryLabelText"><c:out value=" ${sessionScope.ORDERINFO.orderId}"/></span></br>
                      <c:out value="${sessionScope.MESSAGES.Items}" />:  <c:forEach items="${sessionScope.CARTITEMS}" var="temp">
                          <span class="categoryLabelText"> ${temp.title}</span>
                        <span class="categoryLabelText">${temp.category}</span>
                        <span class="categoryLabelText">${temp.price} </span>
                        </br>
                      </c:forEach>
                        </br>
                      
                        <c:out value="${sessionScope.MESSAGES.TOTAL}" />:  <c:out value="${sessionScope.ORDERTOTAL}"/>
                        </br>
                      <form name="confirmOrder" action="OrderServlet">
                          <label><c:out value="${sessionScope.MESSAGES.Card_Number}" />:</label>  <input type="text" name="cardNumber"/></br>
                          <label><c:out value="${sessionScope.MESSAGES.Card_Type}" />:</label>  <select>
  <option value="visa"><c:out value="${sessionScope.MESSAGES.VISA}" /></option>
  <option value="mc"><c:out value="${sessionScope.MESSAGES.Master_Card}" /></option>
  <option value="debit"><c:out value="${sessionScope.MESSAGES.INTERAC}" /></option>
  </select></br>
                                         <label><c:out value="${sessionScope.MESSAGES.Expiry}" /> : </label> <label><c:out value="${sessionScope.MESSAGES.Year}" />:</label> <select>
  <option value="12">2012</option>
  <option value="13">2013</option>
  <option value="14">2014</option>
  </select>
                                         <label><c:out value="${sessionScope.MESSAGES.Month}" />:</label> <select>
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
               

            <%@ include file="/jspf/footer.jspf" %> 


			

