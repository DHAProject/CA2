<%-- 
    Document   : successfulRegistration
    Created on : 2018-12-4, 19:16:50
    Author     : HaiKuo
--%>

<%@page import = "DTOS.User" %>
<%@page import = "DAOS.UserDAO" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "header.jsp" %>
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

        if (checkuser.getUserType(userN) == 1) {
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

    String nameOfNewUser = newUser.getUser_name();

    String message1 = "";
    String message2 = "";

    if (newUser != null) {
        message1 = "Welcome " + nameOfNewUser + " To Emmet's Bookshop";
        User checkUser = new User();
    }
%>

<h3><%=message1%></h3>
</body>
<%@include file = "footer.jsp" %>
</html>
