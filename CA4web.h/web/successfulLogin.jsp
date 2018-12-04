<%-- 
    Document   : successfulLogin
    Created on : 2018-12-4, 19:16:06
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
<h1>You've Logged In Successfully</h1>
<%
    User logedUser = (User) session.getAttribute("login");

    String nameOfUser = logedUser.getUser_name();

    String message1 = "";
    String message2 = "";

    if (logedUser != null) {
        message1 = "Welcome " + nameOfUser + " To Emmet's Bookshop";
        UserDAO checkUser = new UserDAO();

        if (checkUser.getUserType(nameOfUser) == 0) {
            message2 = "You Are Not An Administrator";
        }
    }
%>

<h3><%=message1%></h3>
<h3><%=message2%></h3>
</body>
<%@include file = "footer.jsp" %>
</html>
