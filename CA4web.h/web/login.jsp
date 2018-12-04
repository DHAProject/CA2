<%-- 
    Document   : login
    Created on : 2018-12-4, 16:14:54
    Author     : HaiKuo
--%>

<%@page import="DTOS.User" %>
<%@page import="DAOS.UserDAO" %>
<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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

<%--
<div class ='container'>
    <div class='row main'>
        <div class='panel-heading'>
            <div class='panel-title text-center'>
                <h3 class='title'> Log In</h3>
            </div>
        </div>
        <form class='form-horizontal' method='post' action='FrontController'>
            <div class="form-group">
                <label class="cols-sm-2 control-label">Username</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" name="username" id="name" required  placeholder="Enter your Name"/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="password" class="cols-sm-2 control-label">Password</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-lock fa" aria-hidden="true"></i></span>
                        <input type="password" class="form-control" name="password" id="email" required  placeholder="Enter your password"/>
                    </div>
                </div>
            </div>
            <div class="buttonHolder">
                <input type="submit" value="Login" class="btn btn-default" />
                <!-- Include a hidden field to identify what the user wants to do -->
                <input type="hidden" name ="action" value="login" />

            </div>
        </form>
    </div>
</div>

--%>
</body>
</html>