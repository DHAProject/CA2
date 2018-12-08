<%-- 
    Document   : register
    Created on : 2018-12-4, 19:44:35
    Author     : HaiKuo
--%>

<%@page import="DTOS.User"%>
<%@page import="DAOS.UserDAO"%>

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
                        <label  class="cols-sm-2 control-label">FirstName</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="firstname" id="name" required  placeholder="Enter your First Name" pattern="[A-Za-z]+"/>
                            </div>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label  class="cols-sm-2 control-label">LastName</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="firstname" id="name" required  placeholder="Enter your Last Name" pattern="[A-Za-z]+"/>
                            </div>
                        </div>
                    </div>
                    <%--
                    <div class="form-group">
                        <label  class="cols-sm-2 control-label">Email Address</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                <input type="email" class="form-control" name="email" id="name" required  placeholder="Enter your Email Address" pattern=""/>
                            </div>
                        </div>
                    </div>
                    --%>
                    <div class="form-group">
                                <label for="email">Email Address:</label>
                            
                                <input type="email" name="email"class="form-control"  required autofocus>
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