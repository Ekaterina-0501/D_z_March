<%@page import="org.example.crud.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Update Person info</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<%
String id = request.getParameter("id");
Person person = PersonDao.getPersonByIdUser(Integer.parseInt(id));
%>
<h1>Update Person info</h1>
<div class="regForm3">
<form action="edituseruser.jsp" method="post">
<input type="hidden" name="id" value="<%=person.getId()%>"
    <table>
        <tr><td>Name:_____</td><td><input type="text" name="userName" value="<%=person.getUserName()%>"/></td></tr>
         <p></p>
        <tr><td>Password:___</td><td><input type="password" name="userPass" value="***"/></td></tr>
         <p></p>
        <tr><td>Email:____</td><td><input type="email" name="userEmail" value="<%=person.getUserEmail()%>"/></td></tr>
         <p></p>
        <tr><td>Country:__</td><td>
            <select name="userCountry" style="width:150px">
                <option>India</option>
                <option>USA</option>
                <option>UK</option>
                <option>Other</option>
            </select>
        </td></tr>
         <p></p>
        <tr><td colspan="2"><input type="submit" value="Edit"/></td></tr>
    </table>
</form>

<br/>
</div>
</body>
</html>