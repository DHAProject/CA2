<%-- 
    Document   : BorrowBook
    Created on : 30-Nov-2018, 15:29:48
    Author     : Andrew
--%>

<%@page import="DTOS.User"%>
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
            if (u != null) {
        %>


        <% } else {
                out.println("User not found. Please try logging in.");
            }
        %>

<div class="container">
  <form>
    
    <div class="form-group">
      <label for="userId">User Id</label>
      <input type="text" class="form-control"  placeholder="Enter User ID">
    </div>
    
    <div class="form-group">
      <label for="book_isbn">Book ISBN</label>
      <input type="text" class="form-control" placeholder="Enter Book ISBN">
    </div>
      <div class="form-group">
      <label for="book_title">Title</label>
      <input type="text" class="form-control" placeholder="Enter Book Title">
    </div>
    
    <div class="form-group">
      <label for="loan_startdate">Start Date</label>
      <input type="text" class="form-control" placeholder="Enter today's date" style="width:100%;" size="40">
    </div>
      <div class="form-group">
      <label for="loan_duedate">Due Date</label>
        <input type="text" class="form-control" placeholder="Enter the date 7 days from now" style="width:100%;" size="40">
       </div>

            </form>
        </div>
    </body>
</html>
