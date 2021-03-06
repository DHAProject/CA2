<%-- 
    Document   : updateResult
    Created on : 2018-12-10, 5:02:13
    Author     : HaiKuo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DTOS.User"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <title>Results of Update</title>
    </head>
    <body>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <%@include file = "home.jsp" %>
        <%
            // Get the result from the session (how many users were updated)
            Object resultValue = session.getAttribute("detailUpdated");
            // If we have a result value to use, then display it
            if (resultValue != null)
            {
                // Cast it to a number
                Integer result = (Integer) resultValue;
        %> 
        <!-- display the number of users updated -->
        There were <%=result%> Customers updated in the database.

        <%
            // Check if there were customers updated. If so, get the list of Customers and display them
            if (result > 0)
            {
                // Get the list of updated customers
                List<User> updatedUser = (ArrayList<User>) session.getAttribute("updatedUser");
                // If there is a list of updated customers to use
                if (updatedUser != null)
                {
                    // Deal with displaying
        %>
        <table>
            <tr>
               
                <th>Email</th>
                <th>Last Name</th>
                <th>First Name</th>
            </tr>
            <%
                for (User u : updatedUser)
                {
            %>
            <!-- Create a row for this customer -->
            <tr>
                <!-- Create a cell for each component of this customer's information and fill it with 
                     data in this customer's object -->
               
                <td><%=u.getUser_email()%></td>
                <td><%=u.getUser_lname()%></td>
                <td><%=u.getUser_fname()%></td>
            </tr>
            <%
                    }
                    // We have finished with the list of updated customers list 
                    // so now we can remove the value from the session
                    session.removeAttribute("updatedUser");
                }
            %>
        </table>

        <%
            }
            // We have finished with the numUpdated value 
            // so now we can remove the value from the session
            session.removeAttribute("detailUpdated");
        } else
        {
        %>
            No customer update information found.
        <%
        }
        %>
        
        <!-- Include a footer so that there is always a link back to the home page! -->
        <%@ include file = "footer.jsp" %>
    </body>
</html>

