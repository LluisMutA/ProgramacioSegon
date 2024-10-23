<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    Username:<br>
    <input type="text" name="username">
    <br>
    Password: <br>
    <input type="password" name="password">
    <br>
    <input type="submit" value="Envia">
<h1>${message}</h1>
</form>

</body>
</html>
