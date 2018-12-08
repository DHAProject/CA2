<%-- 
    Document   : register
    Created on : 2018-12-4, 19:44:35
    Author     : HaiKuo
--%>

<%@page import="DTOS.User"%>
<%@page import="DAOS.UserDAO"%>
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
<body>

    <div class="container2">
        <div class="row main">
            <div class="panel-heading">
                <div class="panel-title text-center">
                    <h3 class="title"> Registration</h3>
                </div>
            </div> 
            <div class="main-login main-center">
                <form class="form-horizontal" method="post" action="FrontController">

                    <div class="form-group">
                        <label  class="cols-sm-2 control-label">Name</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="firstname" id="name" required  placeholder="Enter your First Name" pattern="[A-Za-z]+"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="cols-sm-2 control-label">Phone Number</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-phone fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="phone" id="username"  placeholder="Enter your Phone Number" pattern="[0-9]{3}[0-9]{7}" title="Enter 10 Digit Number ie(08612341212)"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="cols-sm-2 control-label">Address Line 1</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-address-book-o fa" aria-hidden="true"></i></span>
                                <input  class="form-control" name="address1" id="confirm"  placeholder="Enter Your Address"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="cols-sm-2 control-label">Address Line 2</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-address-book-o fa" aria-hidden="true"></i></span>
                                <input  class="form-control" name="address2" id="confirm"  placeholder="Enter Your Address"/>
                            </div>
                        </div>
                    </div>

                    

                    <div class="form-group">
                        <label class="cols-sm-2 control-label">Username</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-male fa" aria-hidden="true"></i></span>
                                <input  class="form-control" name="username" id="confirm"  placeholder="Enter Your username"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="cols-sm-2 control-label">Password</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                <input type="password" class="form-control" name="password" id="confirm"  placeholder="Enter Your Password"/>
                            </div>
                        </div>
                    </div>

                    <div class="buttonHolder">
                        <input type="submit" value="Register" class="btn btn-default" />
                        <!-- Include a hidden field to identify what the user wants to do--> 
                        <input type="hidden" name ="action" value="register" />
                    </div>

                    <div class="login-register">

                    </div>
                </form>
            </div>
        </div>
    </div>
--%>
</body>
<%@include file="footer.jsp" %>
</html>