<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
<form method="post">
    Username:<br>
    <input type="text" name="username">
    <br>
    Password: <br>
    <input type="password" name="password">
    <br>
    <input type="submit" value="Enter">
    <br>

<h1>${message}</h1>
</form>

 <br>
 <a href="/Register">New User?</a>

</body>
</html>
