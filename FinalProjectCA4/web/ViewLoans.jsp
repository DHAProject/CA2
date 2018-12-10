<%-- 
    Document   : ViewLoans
    Created on : 9 Dec, 2018, 10:33:46 PM
    Author     : Dhruman
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DTOS.Loan"%>
<%@page import="DAOS.LoanDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>View Loan</title>
    </head>
    <body>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <%@include file = "home.jsp" %>


        <% User u = (User) session.getAttribute("loginUser");
           LoanDAO loDao = new LoanDAO("library_system");
            List<Loan> loan = loDao.getAllLoan();
            
            // If there is a customer list to use in the session (and it's not empty)
            // Carrying out this check avoids the page breaking when the session times out
            
            if(u!=null && loan != null && !loan.isEmpty())
            {
          //  Loan l = new Loan();
            
        %>
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Loan Id</th>
                    <th scope="col">User ID</th>
                    <th scope="col">Book Isbn</th>
                    <th scope="col">Loan Start ate</th>
                    <th scope="col">Loan Due Date</th>
                    <th scope="col">Loan Return Date</th>
                </tr>
            </thead>
            <%
                for(Loan l : loan)
                {
            %>
            <tbody>
                <tr>
                    <th scope="row"><%=l.getLoan_id()%></th> 
                    <td><%=l.getUser_id()%></td>
                    <td><%=l.getBook_isbn()%></td>
                    <td><%=(java.sql.Date)l.getLoan_startdate()%></td>
                    <td><%=(java.sql.Date)l.getLoan_duedate()%></td>
                    <td><%=(java.sql.Date)l.getLoan_returndate()%></td>
                </tr>
                    
                </tr>
            </tbody>
            <%}%>
        </table>






        <%
}
        %>

    </body>
</html>
