<%-- 
    Document   : register
    Created on : 2018-12-4, 19:44:35
    Author     : HaiKuo
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>Registration </title>
</head>
<body class="bg-light">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>

    <%@include file = "header.jsp" %>


    <div class="container">
        <div class="py-1 text-center">

            <h2>Registration form</h2>
        </div>
        <div class="row">
            <div class="col-sm-6"><br><br><br></div> </div>

        <div class="row">
            <div class="col-sm-4"></div> 
            <div class="col-sm-5">

                <div class="container">
                    <form action="Servlet" method="Post">
                        <div class="form-group">
                            <label for="Text">First Name:</label>
                            <input type="text" name="fname"class="form-control"  required autofocus>
                        </div>
                        <div class="form-group">
                            <label for="Text">Last Name:</label>
                            <input type="text" name="lname"class="form-control"  required autofocus>
                        </div>
                        <div class="form-group">
                            <label for="email">Email address:</label>
                            <input type="email" name="email"class="form-control"  required autofocus>
                        </div>
                        <div class="form-group">
                            <label for="pwd">Password:</label>
                            <input type="password" name="password" class="form-control"  required>
                        </div>
                        <div class="form-group">
                            <label for="text">Phone No.</label>
                            <input type="text" name="phoneno"class="form-control"  required autofocus>
                        </div>

                        <center> <button type="submit" class="btn btn-primary" value="register">Register</button></center>
                        <input type="hidden" name ="action" value="register" />
                    </form>
                </div>
            </div></div> </div>


    <%@include file="footer.jsp" %>
</body>

</html>