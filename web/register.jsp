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
                <form method="post" action="/AccountServlet" id="Registerform">

                    <label class="login"> First Name: </label><input type="text" class="uname" name="fname" /><br>
                    <label class="login">First Name: </label> <input type="text" class="uname" name="lname" /><br>
                    <label class="login"> User Name: </label><input type="text" class="uname" name="uname" /><br>
                    <label class="login">Password: </label> <input type="password" class="password" name="passord1" /><br>
                    <label class="login"> Re-type password: </label><input type="password" class="password" name="password2" /><br>
                    <label class="login"> Street: </label><input type="text" class="uname" name="fname" /><br>
                    <label class="login">Province: </label> <select name="province" class="dropdown">
                        <option value="AB">AB</option>
                        <option value="BC">BC</option>
                        <option value="MB">MB</option>
                        <option value="ON">ON</option>
                    </select><br>
                    <label class="login">ZIP </label> <input type="text" class="uname" name="zip" /><br>
                    <label class="login"> Phone </label><input type="text" class="uname" name="phone" /><br>

                    <input type="submit" value="Register" />

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
