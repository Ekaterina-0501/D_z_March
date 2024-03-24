<%@page import="org.example.crud.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

</head>
<body>
<%
HttpSession httpSession = request.getSession();
if(session == null){
	response.sendRedirect("auth.html");
}
else {
String ID = (String) httpSession.getAttribute("id");
String userName = (String) httpSession.getAttribute("userName");
String userEmail = (String) httpSession.getAttribute("userEmail");
String userCountry = (String) httpSession.getAttribute("userCountry");
}
%>
<h3>Hello ${sessionScope.userName}</h3>
Your data:

<p>Your name ${sessionScope.userName}</p>
<p>Your email ${sessionScope.userEmail}</p>
<p>Your country ${sessionScope.userCountry}</p>
<td><a href ="editformuser.jsp?id=${sessionScope.ID}">edit</a></td>
<form action="logout" method="post">
<input type="submit" value="Logout" >
</form>
</body>
</html>