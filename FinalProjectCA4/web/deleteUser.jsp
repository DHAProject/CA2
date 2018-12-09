<%-- 
    Document   : deleteUser
    Created on : 2018-12-4, 19:18:40
    Author     : HaiKuo
--%>

<%@page import="DTOS.User"%>
<%@page import="DAOS.UserDAO"%>



<title>Delete User</title>
</head>
<body>
    <h3>Enter User's Email You Want To Delete</h3>
    <br /><br />
    <div class="main-login main-center">
        <form class="form-horizontal" method="post" action="FrontController">

            <div class="form-group">
                <label  class="cols-sm-2 control-label">Enter Useremail: </label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-trash-o fa" aria-hidden="true"></i></span>
                        <input type="email" class="form-control" name="user_email" id="name" required  placeholder="Enter Useremail"/>
                    </div>
                    <br /><br />
                    <center>
                        <input type="submit" value="Delete User" class="btn btn-default" />
                        <!-- Include a hidden field to identify what the user wants to do -->
                        <input type="hidden" name ="action" value="deleteUser" />
                    </center>
                </div>
            </div>
        </form>
    </div>
</body>
<%@include file = "footer.jsp" %>
</html>
