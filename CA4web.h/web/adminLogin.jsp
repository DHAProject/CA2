<%-- 
    Document   : adminLogin
    Created on : 2018-12-4, 19:07:44
    Author     : HaiKuo
--%>



<%@page import="DAOS.UserDAO"%>
<%@page import="DTOS.User"%>


<%@page import = "java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "header.jsp" %>
<%
    try {
        if (session.getAttribute("login") == null) {
%>



<% }
    if (session.getAttribute("login") != null) {
        UserDAO checkuser = new UserDAO();
        User loggedUser = (User) session.getAttribute("login");
        String userN = loggedUser.getUser_name();

        if (checkuser.getUserType(userN) == 1) {
%>


<% } else { %>

<%
            }
        }
    } catch (Exception ex) {
        out.println(ex.getMessage());
    }
%>
<title>Admin Log In Section</title>
</head>
<body>
    <h1>Log In Successful</h1>

    <%
        User logedUser = (User) session.getAttribute("login");

        String userN = logedUser.getUser_name();

        java.util.Date date = new java.util.Date();
        String mgs = "", mgs2 = "", mgs3 = "";

        if (logedUser != null) {
            mgs = "Welcome Back to the BookShop " + userN;
            UserDAO checkuser = new UserDAO();

            if (checkuser.getUserType(userN) == 1) {
                mgs3 = "UserType: Admin";
            }

        }
       
    %>
</body>
<%@include file = "footer.jsp" %>
</html>
