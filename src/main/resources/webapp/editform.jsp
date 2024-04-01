<%@page import="org.example.crud.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Update Person info</title>
</head>
<body>
<%
String id = request.getParameter("id");
Person person = PersonDao.getPersonById(Integer.parseInt(id));
%>
<h1>Update Person info</h1>
<form action="edituser.jsp" method="post">
<input type="hidden" name="id" value="<%=person.getId()%>"
    <table>
        <tr><td>Name:</td><td><input type="text" name="userName" value="<%=person.getUserName()%>"/></td></tr>
        <tr><td>Password:</td><td><input type="password" name="userPass" value="***"/></td></tr>
        <tr><td>Email:</td><td><input type="email" name="userEmail" value="<%=person.getUserEmail()%>"/></td></tr>
        <tr><td>Country:</td><td>
            <select name="userCountry" style="width:150px">
                <option>India</option>
                <option>USA</option>
                <option>UK</option>
                <option>Other</option>
            </select>
        </td></tr>
        <tr><td>Role:</td><td>
                            <select name="role" style="width:150px">
                                <option>USER</option>
                                <option>ADMIN</option>
                            </select>
                 </td></tr>
        <tr><td colspan="2"><input type="submit" value="Edit"/></td></tr>
    </table>
</form>

<br/>

</body>
</html>
