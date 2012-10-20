<%-- 
    Document   : login
    Created on : Oct 19, 2012, 8:22:39 PM
    Author     : Aman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
            <div>
            <!-- Start of content left and right column-->
            <form method="post" action="/UserServlet" id="loginform">
                
                <label class="login"> User Name: </label><input type="text" class="uname" name="username" /><br>
                <label class="login">Password: </label> <input type="password" class="password" name="password" /><br>
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
			


		
                        <!-- End of content left and right column-->
			<div id="footer">
                            <hr>
                            <p id="footerText">[ footer text ]</p>
			</div>
		</div>
    </body>
</html>
