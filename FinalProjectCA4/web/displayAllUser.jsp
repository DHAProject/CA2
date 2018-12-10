<%-- 
    Document   : displayAllUser
    Created on : 2018-12-10, 4:13:30
    Author     : HaiKuo
--%>

<%@page import="java.util.List"%>
<%@page import="DAOS.UserDAO"%>
<%@page import="DTOS.User"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@include file = "header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display All Customers</title>
    </head>
    <body>
        <body>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <%@include file = "home.jsp" %>
      
        <h1>User list</h1>
        <%
            UserDAO displayU = new UserDAO("library_system");
            List<User> user = displayU.getAllUsers();
            // If there is a user list to use in the session (and it's not empty)
            
            // Carrying out this check avoids the page breaking when the session times out
            
            if (user != null && !user.isEmpty())
            {
        %>
        <!-- set up table structure -->
        <table>
            <tr>
                <th>ID</th>
                <th>Email</th>
                <th>Last Name</th>
                <th>First Name</th>
            </tr>
            <%
                // Loop to print out all of the rows
                for (User u : user)
                {
            %>
            <!-- Create a row for this user -->
            <tr>
                <!-- Create a cell for each component of this user's information and fill it with 
                     data in this user's object -->
                <td><%=u.getUser_id()%></td>
                <!-- Line to generate a tailored link that will go to the view Customer page and pass it the id of the customer to be selected from the database -->
                <td><a href="viewProfile.jsp?uNum=<%=u.getUser_id()%>"><%=u.getUser_email()%></a></td>
                <td><%=u.getUser_lname()%></td>
                <td><%=u.getUser_fname()%></td>
            </tr>
            <%
                    // Close the loop
                }
            %>

        </table>
        <%
            } else
            {
                out.println("No user found. Please try again.");
            }
        %>
        <!-- Include a footer so that there is always a link back to the home page! -->
        <%@ include file = "footer.jsp" %>
    </body>
</html>
