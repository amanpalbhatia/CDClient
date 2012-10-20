<%-- 
    Document   : productsByCategory
    Created on : Oct 19, 2012, 8:20:44 PM
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

            </div>


            <div id="indexRightColumn">
                <h2>Results  </h2>
                <c:forEach items="${prod}" var="temp">
                    <div class="categoryBox"> 

                        <span class="categoryLabelText"> ${temp.title} </span>
                        </br> ${temp.price} </br>[add to cart button]
                        </br> 
                    </div>
                </c:forEach>


            </div>

            <!-- End of content left and right column-->
            <div id="footer">
                <hr>
                <p id="footerText">[ footer text ]</p>
            </div>
        </div>
    </body>
</html>
