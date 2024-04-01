<%@page import="org.example.crud.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>View Persons</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="background">
<h1>Persons list</h1>
<%
ArrayList<Person> arrayList = PersonDao.getAllPersons();
request.setAttribute("arrayList",arrayList);
%>
<table>
<tr>
<td>Id:</td>
<td>Name:</td>
<td>Password:</td>
<td>Email:</td>
<td>Country:</td>
<td>Role:</td>
</tr>
<c:forEach items="${arrayList}" var="person">
<tr>
<td>${person.getId()}</td>
<td>${person.getUserName()}</td>
<td>${person.getUserPass()}</td>
<td>${person.getUserEmail()}</td>
<td>${person.getUserCountry()}</td>
<td>${person.getRole()}</td>
<td><a href ="editform.jsp?id=${person.getId()}">edit</a></td>
<td><a href ="deleteuser.jsp?id=${person.getId()}" ><button>delete</button></td>
</tr>
</c:forEach>
</table>
<p></p>
<a href = "reg.jsp"><button>Add new Person</button></a>
<p></p>
<form action="logout" method="post">
<input type="submit" value="Logout" >
</div>
</body>
</html>