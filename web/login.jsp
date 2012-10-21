<%-- 
    Document   : login
    Created on : Oct 19, 2012, 8:22:39 PM
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
        
        
        <% 
        %>
        
        <div id="main">
            
            <div id="header">
                  <div id="widgetBar">
                        <div class="headerWidget">
                            [ language toggle ]
                        </div>
                        

                        <div class="headerWidget">
                            [ items in cart ]
                        </div>
                        
                        <div class="headerWidget">
                            [ login or Hi, user]
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
                                                </div>


			<div id="indexRightColumn">
				<h2>Log-in </h2>
            <div class="loginBox">
            <!-- Start of content left and right column-->
            <label class="categoryLabelText"><c:out value="${loginmsg}" /></label>
            <label class="categoryLabelText"><c:out value="${chkoutmsg}" /></label>
            
            <form method="post" action="UserServlet" id="loginform">
                
                <label class="categoryLabelText"> User Name: </label><input type="text" class="inputbox" name="username" /><br>
                <label class="categoryLabelText">Password: </label> <input type="password" class="inputbox" name="password" /><br>
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
			<div id="footer">
                            <hr>
                            <p id="footerText">[ footer text ]</p>
			</div>
        </div>
        
		
    </body>
</html>
