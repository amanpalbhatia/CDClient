<%-- 
    Document   : login
    Created on : Oct 19, 2012, 8:22:39 PM
    Author     : Aman
--%>

<%-- 
    Document   : index
    Created on : Oct 19, 2012, 5:57:25 PM
    Author     : Aman
--%>
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/jspf/header.jspf" %> 
                    
            <%@ include file="/jspf/leftsidebar.jspf" %> 

			<div id="indexRightColumn">
				<h2><c:out value="${sessionScope.MESSAGES.Register}" /></h2>
                             <span class="categoryLabelText"> <c:out value="${registermsg}" /></span>   
						<div class="RegisterBox"> 
                                                    <form name="register" method="post" action="UserServlet" onSubmit="return validateForm()">
                                                        <input type="hidden" name="register" value="register">
  <span class="categoryLabelText"> First Name : </span>
<input type="text" name="fname"/> </br>
<span class="categoryLabelText"> Last Name : </span>
<input type="text" name="lname"/> </br>
<span class="categoryLabelText"> Street : </span>
<input type="text" name="street"/> </br>
<span class="categoryLabelText"> Province : </span>
<input type="text" name="province"/> </br>
<span class="categoryLabelText"> ZIP : </span>
<input type="text" name="zip"/> </br>
<span class="categoryLabelText"> Country : </span>
<input type="text" name="country"/> </br>
<span class="categoryLabelText"> Phone : </span>
<input type="text" name="phone"/> </br>
<span class="categoryLabelText"> User Name : </span>
<input type="text" name="uname"/> </br>
<span class="categoryLabelText"> Password : </span>
<input type="password" name="pwd"/> </br>
<span class="categoryLabelText"> Re-type Password : </span>
<input type="password" name="repwd"/> </br>

<input type="submit" name="Register"/> </br>                        </form>

						</div>

			</div>
            
                        
                                                   <!-- End of content left and right column-->
			<%@ include file="/jspf/footer.jspf" %> 
