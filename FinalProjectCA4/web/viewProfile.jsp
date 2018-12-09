<%-- 
    Document   : viewProfile
    Created on : 2018-12-8, 18:28:58
    Author     : HaiKuo
--%>


<%@page import="DTOS.Address"%>
<%@page import="DTOS.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "header.jsp" %>



<h1>Welcome To Your Profile</h1>
<%
    User logedUser = (User) session.getAttribute("login");
    Address logedAdd = (Address) session.getAttribute("login");

    String userfname = logedUser.getUser_fname();
    String userlname = logedUser.getUser_lname();
    String phoneNumber = logedUser.getUser_phoneno();
    String address1 = logedAdd.getAddress_1();
    String address2 = logedAdd.getAddress_2();
    String address3 = logedAdd.getAddress_3();
    

    String message1 = "";
    String message2 = "";
    String message3 = "";
    String message4 = "";
    String message5 = "";
    String message6 = "";
    

    if (logedUser != null && logedAdd !=null) {
        message1 = userfname;
        message2 = userlname;
        message3 = phoneNumber;
        message4 = address1;
        message5 = address2;
        message6 = address3;
        
    }
%>
<br/>
<h2>Here Is Your Personal Information</h2>
<table>
    <tr>
        <th>user first name: </th>
        <td><%=message1%></td>
    </tr>

    <tr>
        <th>user last name: </th>
        <td><%=message2%></td>
    </tr>

    <tr>
        <th>Contact Number: </th>
        <td><%=message3%></td>
    </tr>

    <tr>
        <th>Address: </th>
        <td><%=message4%></td>
    </tr>

    <tr>
        <th></th>
        <td><%=message5%></td>
    </tr>

    <tr>
        <th></th>
        <td><%=message6%></td>
    </tr>
    
</table>
</body>
<%@include file="footer.jsp" %>
</html>
