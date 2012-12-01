<%-- 
    Document   : login
    Created on : Oct 19, 2012, 8:22:39 PM
    Author     : Aman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/jspf/header.jspf" %> 
                    
            <%@ include file="/jspf/leftsidebar.jspf" %> 

			<div id="indexRightColumn">
				<h2><c:out value="${sessionScope.MESSAGES.Login}" /> </h2>
            <div class="loginBox">
            <!-- Start of content left and right column-->
            <label class="categoryLabelText"><c:out value="${loginmsg}" /></label>
            <label class="categoryLabelText"><c:out value="${chkoutmsg}" /></label>
            
            <form method="post" action="UserServlet" id="loginform">
                
                <label class="categoryLabelText"> <c:out value="${sessionScope.MESSAGES.User_Name}" />: </label><input type="text" class="inputbox" name="username" /><br>
                <label class="categoryLabelText"><c:out value="${sessionScope.MESSAGES.Password}" />: </label> <input type="password" class="inputbox" name="password" /><br>
               <input type="submit" value="log in" />
            </form>
            </div>


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
		
                        <!-- End of content left and right column-->
	<%@ include file="/jspf/footer.jspf" %> 
