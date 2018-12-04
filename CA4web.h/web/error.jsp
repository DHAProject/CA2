<%-- 
    Document   : error
    Created on : 2018-12-4, 19:13:25
    Author     : HaiKuo
--%>

<%@page import="DTOS.User"%>
<%@page import="DAOS.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DHA's Book Shop</title>
    </head>
    <body>
        <%
            try {
                if (session.getAttribute("login") == null) {
        %>
        
        <>
        
        <% }
            if (session.getAttribute("login") != null) {
                UserDAO checkuser = new UserDAO();
                User loggedUser = (User) session.getAttribute("login");
                String userN = loggedUser.getUser_name();

                if (checkuser.getUserisadmin(userN) == 1) {
        %>

        <>
        
        <% } else { %>

        <>
        
        <%
                    }
                }
            } catch (Exception ex) {
                out.println(ex.getMessage());
            }
        %>

        <br/>
        <br/>
        <%
            Object msg = session.getAttribute("errorMessage");
            String error = (String) msg;
        %>

        <div class="alert alert-danger">
            <strong><%=error%></strong>
        </div>

        <%
            session.removeAttribute("errorMessage");
        %>
        <br /><br />
    <center><input type="button" value="Back" onclick="window.history.back()" /></center> 
</body>
</html>
