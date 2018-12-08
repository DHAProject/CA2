<%-- 
    Document   : logout
    Created on : 2018-12-4, 16:15:48
    Author     : HaiKuo
--%>

<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <>
    
    <body>
        <h1>You Have Logged Out...</h1>

        <%
            session.removeAttribute("login");
            session.removeAttribute("register");
            session.invalidate();
            response.sendRedirect("index.jsp");
        %>

        <a href="index.jsp">Back To index</a>
    </body>
</html>
