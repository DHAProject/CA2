<%-- 
    Document   : searchBook
    Created on : 08-Dec-2018, 14:55:35
    Author     : Andrew
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Business.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Book</title>
        
        <%
            // Retrieve the resource bundle from the session
            ResourceBundle dataBundle = (ResourceBundle) session.getAttribute("dataBundle");
            // If there is no bundle stored (i.e. if this is the first time you're coming to the site)
            if(dataBundle == null){
                // Create a resource bundle based on the client's current locale settings
                dataBundle = ResourceBundle.getBundle("properties.ClassicModels", clientLocale);

                // Store this resource bundle for future use
                session.setAttribute("dataBundle", dataBundle);
            }
            
        %>
    </head>
    <body>
        <%
            // search
            ArrayList<Book> searchBook = (ArrayList<Book>) session.getAttribute("search");
            if(searchBook !=null){
                for(Book b : searchBook){
            %>
          
            <BR>
            <%=dataBundle.getInt("index_book_isbn")%> <%=b.getBook_ISBN()%>
            <BR>
           <%=dataBundle.getString("index_book_title")%> <%=b.getBook_Title()%>
            <BR>
            <%=dataBundle.getString("index_book_author")%> <%=b.getBook_Author()%>
            <BR>
            <%=dataBundle.getString("index_book_publisher")%> <%=b.getBook_Publisher()%>
            <BR>
            <%=dataBundle.getString("index_book_description")%> <%=b.getBook_Description()%>
            <BR>
           <%=dataBundle.getInt("index_book_quantity")%> <%=b.getBook_Quantity()%>
            
       
            <%
                }
}else{
    out.println("not found");
}
%>
    </body>
</html>
