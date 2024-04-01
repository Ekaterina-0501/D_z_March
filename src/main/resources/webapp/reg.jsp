<%@page import="org.example.crud.*,java.util.*"%>
<jsp:useBean id = "p" class = "org.example.crud.Person"></jsp:useBean>
<jsp:setProperty property = "*" name= "p"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="reg.css">
</head>
<body>

<h1>Add New Person</h1>
<form action="reg" method="post">
    <table>
        <tr><td>Name:</td><td><input type="text" name="userName"/></td></tr>
        <tr><td>Password:</td><td><input type="password" name="userPass"/></td></tr>
        <tr><td>Email:</td><td><input type="email" name="userEmail"/></td></tr>
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

        <tr><td colspan="2"><input type="submit" value="register"/></td></tr>
    </table>
</form>

<br/>

<p></p>
<a href="viewusers.jsp">view all users</a>
<form action="logout" method="post">
<input type="submit" value="Logout" >

</body>
</html>