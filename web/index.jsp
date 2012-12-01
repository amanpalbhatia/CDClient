<%-- 
    Document   : index
    Created on : Oct 19, 2012, 5:57:25 PM
    Author     : Aman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ include file="/jspf/header_index.jspf" %> 
                    
            <%@ include file="/jspf/leftsidebar.jspf" %> 
            

			<div id="indexRightColumn">
                                <h2><c:out value="${sessionScope.MESSAGES.welcome}" /></h2>
                                <span> <c:out value="${sessionScope.MESSAGES.browseGuide1}" /> </br>
                                   <c:out value="${sessionScope.MESSAGES.browseGuide2}" /></span>
                                </br></br> <span> <c:out value="${sessionScope.MESSAGES.checkoutGuide1}" /> </br> <c:out value="${sessionScope.MESSAGES.checkoutGuide2}" /> </span>
                                </br> 
                                <h4> <c:out value="${sessionScope.MESSAGES.thanks}" /> </h4>
                                ----------</br>
                                <span class="categoryLabelText"> <c:out value="${registermsg}" /></span>
<label class="categoryLabelText"><c:out value="${chkoutmsg}" /></label>
 <label class="categoryLabelText"> <c:out value="${confirmOrderMsg}" /></label>
						


			</div>
            
                        <!-- End of content left and right column-->
			<%@ include file="/jspf/footer.jspf" %> 
 

