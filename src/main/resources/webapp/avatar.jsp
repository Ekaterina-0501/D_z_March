<%@page import="org.example.crud.*,java.util.*"%>
<jsp:useBean id = "p" class = "org.example.crud.Person"></jsp:useBean>
<jsp:setProperty property = "*" name= "p"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>welcome page</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<h1>upload or change your avatar</h1>

<div class="regForm">

    <img src="avatar/zero.jpg"width="200" height="211" alt="avatar" />
    <form action="avatar" method="post" enctype="multipart/form-data">
    Select File:<input type="file" name="fname"/><br/>

        <p></p>
        <input type="submit" value="upload"/>
    </form>
</div>


</body>
</html>
