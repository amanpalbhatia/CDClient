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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>e-Techies CD Store</title>
        <script>
        function validateForm()
{
    if(document.register.uname.value=="")
    {
      alert("Enter UserName");
      document.register.username.focus();
      return false;
    }
    else if(document.register.pwd.value!=document.register.repwd.value)
    {
      alert("Password and Re-type password not match");
      document.register.pwd.focus();
      return false;
    }
}
</script>
    </head>
    <body>
 <div id="main">
            
            <div id="header">
                  <div id="widgetBar">
                      <div class="headerWidget">
                            [ Sign Out ]
                        </div>
                        <div class="headerWidget">
                            <a href="register.jsp">[ Register ]</a>
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
				<h2>Register</h2>
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
			<div id="footer">
                            <hr>
                            <p id="footerText">[ footer text ]</p>
			</div>
		</div>
    </body>
</html>

