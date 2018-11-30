<%-- 
    Document   : BorrowBook
    Created on : 30-Nov-2018, 15:29:48
    Author     : Andrew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Borrow Books</title>
    </head>
    <body>
        <% User u = (User) session.getAttribute("login");
        if (u!= null) {
            %>
            
            <% }
else {
out.println("User not found. Please try logging in.")
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
      <input type="text" class="form-control" placeholder="Date" style="width:100%;" size="40">
    </div>
      <div class="form-group">
      <label for="loan_duedate">Due Date</label>
        <input type="text" class="form-control" placeholder="Date" style="width:100%;" size="40">
       </div>

    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
    </body>
</html>
