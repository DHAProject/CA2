<%-- 
    Document   : login
    Created on : 30 Nov, 2018, 3:36:46 PM
    Author     : Dhruman
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Login</title>
    </head>
    <body>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>

        <%@include file = "header.jsp" %>

        <%
            // Check if they have landed here because their session expired
            String sessionExpired = (String) session.getAttribute("sessionExpired");
            // If so, then display the session expired message to the user
            if (sessionExpired != null) {
                // Display the error message to the user
                out.println("<b>" + sessionExpired + "</b>");
                // Remove the message from the session as it's no longer useful
                session.removeAttribute("sessionExpired");
            }
        %>

        <div class="row">
            <div class="col-sm-4"><br><br><br></div> </div>

        <div class="row">
            <div class="col-sm-4"></div> 
            <div class="col-sm-4">
                <div class="jumbotron jumbotron-fluid">
                    <div class="container">
                        <form action="Servlet" method="Post">

                            <div class="form-group">
                                <label for="email">Email address:</label>

                                <input type="email" name="email"class="form-control"  required autofocus>
                            </div>
                            <div class="form-group">
                                <label for="pwd">Password:</label>


                                <input type="password" name="password" class="form-control"  required>
                            </div>

                            <center> <button type="submit" class="btn btn-primary" value="login">Submit</button></center>
                            <input type="hidden" name ="action" value="login" />
                        </form>
                    </div>
                </div></div> </div>
    </div>
<%@include file = "footer.jsp" %>
</body>

</html>
