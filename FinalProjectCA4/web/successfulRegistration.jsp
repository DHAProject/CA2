<%-- 
    Document   : successfulRegistration
    Created on : 2018-12-4, 19:16:50
    Author     : HaiKuo
--%>

<%@page import = "DTOS.User" %>
<%@page import = "DAOS.UserDAO" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    try {
        if (session.getAttribute("login") == null) {
%>
<>

<% }
    if (session.getAttribute("login") != null) {
        UserDAO checkUser = new UserDAO();
        User loggedUser = (User) session.getAttribute("login");
        String userE = loggedUser.getUser_email();

        if (checkUser.getUser_isadmin(userE) == 1) {
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
<h1>You've Successfully Registered</h1>
<%
    User newUser = (User) session.getAttribute("login");

    String nameOfNewUser = newUser.getUser_email();

    String message1 = "";
    String message2 = "";

    if (newUser != null) {
        message1 = "Welcome " + nameOfNewUser + " To DHA's Bookshop";
       UserDAO checkUser = new UserDAO();
    }
%>

<h3><%=message1%></h3>
</body>
<%@include file = "footer.jsp" %>
</html>
