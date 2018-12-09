<%-- 
    Document   : BookDetails
    Created on : 27-Nov-2018, 18:06:20
    Author     : Andrew
--%>

<%@page import="Business.Book"%>
<%@page import="DTOS.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% User u = (User) session.getAttribute("login");
        Book b = (Book) session.getAttribute("bookList");
        
        if (u!= null && b != null) {
            %>
            <BR>
            ISBN: <%=b.getBook_isbn()%>
            <BR>
            Title: <%=b.getBook_title()%>
            <BR>
            Author: <%=b.getBook_author()%>
            <BR>
            Publisher: <%=getBook_publisher()%>
            
            <%
                }
else { out.println("Could not retrieve book details at this time. Please try again");   
        }
%>
    </body>
</html>
