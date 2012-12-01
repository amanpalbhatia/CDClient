<%-- 
    Document   : productsByCategory
    Created on : Oct 19, 2012, 8:20:44 PM
    Author     : Aman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/jspf/header.jspf" %> 
                    
            <%@ include file="/jspf/leftsidebar.jspf" %> 

            <div id="indexRightColumn">
                <c:out value="${cartmsg}" />
                    
                <h2><c:out value="${sessionScope.MESSAGES.Results}" />  </h2>
                <c:forEach items="${prod}" var="temp">
                    <div class="productBox"> 

                        <span class="categoryLabelText"> ${temp.title} </span>
                        </br> ${temp.price} </br>
                        
                        <span>  <a href='AddToCart?action=add&cdId=<c:out value="${temp.cdId}"> </c:out>'>[<c:out value="${sessionScope.MESSAGES.add_cart}" />]</a></span>
                        </br> 
                    </div>
                </c:forEach>


            </div>

            <!-- End of content left and right column-->
            <%@ include file="/jspf/footer.jspf" %> 
