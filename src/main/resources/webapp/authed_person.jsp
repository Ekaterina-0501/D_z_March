<%@page import="org.example.crud.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="style.css">

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
String nameFileAvatar = (String) httpSession.getAttribute("nameFileAvatar");

}
%>
<img src = ${sessionScope.nameFileAvatar} width="200" height="211" alt="avatar" />
<div class="regForm2">
<p><a href = "avatar.jsp"><button>upload or change your avatar</button></a></p>
</div>
<div class="regForm1">

<h3>Hello ${sessionScope.userName}</h3>
Your data:

<p>Your name ${sessionScope.userName}</p>
<p>Your email ${sessionScope.userEmail}</p>
<p>Your country ${sessionScope.userCountry}</p>
</div>
<div class="regForm2">
<td><a href ="editformuser.jsp?id=${sessionScope.ID}">edit</a></td>
</div>
<div class="regForm2">
<form action="logout" method="post">
<input type="submit" value="Exit" >
</form>
</div>
</body>
</html>