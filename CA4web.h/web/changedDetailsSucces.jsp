<%-- 
    Document   : changeDetailsSuccessful
    Created on : 2018-12-4, 19:53:20
    Author     : HaiKuo
--%>

<%@page import="DTOS.User"%>
<%@page import="DAOS.UserDAO"%>

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
<title>Details Changed</title>
<div class="alert alert-success">
    
    <h2>Details Changed Successfully!</h2>
    <h5>Changes will update on next Login</h5>
    
</div>
<%
    session.removeAttribute("login");
%>
<br /><br />
<center><input type="button" value="Back" onclick="window.history.back()" /></center> 
</body>
<%@include file = "footer.jsp" %>
</html>