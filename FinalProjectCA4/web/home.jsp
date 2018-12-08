<%-- 
    Document   : home
    Created on : 4 Dec, 2018, 3:06:50 PM
    Author     : Dhruman
--%>
<%@page import="DTOS.User"%>
<%@page import="DAOS.UserDAO" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>User</title>
    </head>
    <body>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <%
            User loginUser = (User) session.getAttribute("loginUser");
            if (loginUser != null) {

                if (loginUser.isUser_isadmin() == true) {


        %>

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">Library System Project(DHA)</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#"> Add Book</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#"> View Book</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Loan</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Students</a>
                    </li>


                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    <div class="mx-auto" style="width: 100px;"></div>
                    <div class="mx-auto" style="width: 200px;">

                        <lable style="color:white;" >Welcome <%=loginUser.getUser_fname()%>
                            <%=loginUser.getUser_lname()%></lable>


                    </div>
                    <a href="#" class="btn btn-dark  " role="button" aria-pressed="true">Profile</a>
                    <a href="Servlet?action=logout" class="btn btn-dark  " role="button" aria-pressed="true">Logout</a>

                </form>
            </div>
        </nav>


        <%
        } else {

        %>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">Library System Project(DHA)</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">View Book</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Loan</a>
                    </li>

                </ul>

                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    <div class="mx-auto" style="width: 100px;"></div>
                    <div class="mx-auto" style="width: 300px;">

                        <lable style="color:white;" >Welcome <%=loginUser.getUser_fname()%> <%=loginUser.getUser_lname()%></lable>


                    </div>
                    <a href="#" class="btn btn-dark  " role="button" aria-pressed="true">Profile</a>
                    <a href="Servlet?action=logout" class="btn btn-dark  " role="button" aria-pressed="true">Logout</a>

                </form>
            </div>
        </nav>
        <%
                }
            } else {
                String sessionExpired = "Your session has expired, please log in again.";
                session.setAttribute("sessionExpired", sessionExpired);
                response.sendRedirect("login.jsp");
            }

//}
%>
<%@include file = "footer.jsp" %>
    </body>
</html>
