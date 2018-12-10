<%-- 
    Document   : deleteUser
    Created on : 2018-12-4, 19:18:40
    Author     : HaiKuo
--%>

<%@page import="DTOS.User"%>
<%@page import="DAOS.UserDAO"%>

<body>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <%@include file = "home.jsp" %>
        <% User u = (User) session.getAttribute("loginUser");
            if (u != null) {
        %>


        <% } else {
                out.println("User not found. Please try logging in.");
            }
        %>

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
