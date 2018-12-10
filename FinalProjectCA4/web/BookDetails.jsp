<%-- 
    Document   : BookDetails
    Created on : 27-Nov-2018, 18:06:20
    Author     : Andrew
--%>

<%@page import="java.util.List"%>
<%@page import="DAOS.BookDAO"%>
<%@page import="DTOS.Book"%>
<%@page import="DTOS.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    < <head>
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
        <% User u = (User) session.getAttribute("login");
        BookDAO boDao = new BookDAO("library_system");
            List<Book> books = boDao.getAllBooks();
        
        if (u!= null && books != null && !books.isEmpty()) {
            %>
            <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Book Isbn</th>
                    <th scope="col">Title</th>
                    <th scope="col">Author</th>
                    <th scope="col">Publisher</th>
                    <th scope="col">Description</th>
                    
                </tr>
            </thead>
            <%
                for(Book b : books)
                {
            %>
            <tbody>
                <tr>
                    <th scope="row"><%=b.getBook_isbn()%></th> 
                    <td><%=b.getBook_title()%></td>
                    <td><%=b.getBook_author()%></td>
                    <td><%=b.getBook_publisher()%></td>
                    <td><%=b.getBook_description()%></td>
                  
                </tr>
                    
                </tr>
            </tbody>
          
        </table>
  <%}%>





        <%
}
        %>

            
    </body>
    
</html>
