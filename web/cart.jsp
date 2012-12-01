<%-- 
    Document   : index
    Created on : Oct 19, 2012, 5:57:25 PM
    Author     : Aman
--%>
<%@ include file="/jspf/header.jspf" %> 
<%@ include file="/jspf/leftsidebar.jspf" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>

			<div id="indexRightColumn">
				<h2><c:out value="${sessionScope.MESSAGES.Cart}" /></h2>

						<c:forEach items="${sessionScope.CARTITEMS}" var="temp">
                    <div class="productBox"> 

                        <span class="categoryLabelText"> ${temp.title} </span>
                        </br> ${temp.price} </br>
                        
                        <span>  <a href='AddToCart?action=remove&cdId=<c:out value="${temp.cdId}"> </c:out>'>[<c:out value="${sessionScope.MESSAGES.Remove_cart}" />]</a></span>
                        </br> 
                    </div>
                </c:forEach>


			</div>
            <c:out value="${sessionScope.USERINFO.uname}" />
                        
                                                
                        <!-- End of content left and right column-->
			<%@ include file="/jspf/footer.jspf" %> 
