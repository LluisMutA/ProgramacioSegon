<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Registro</title>
</head>
<body>
<form method="post">
    Username:<br>
    <input type="text" name="username">
    <br>
    Name:<br>
       <input type="text" name="name">
       <br>
   Password: <br>
    <input type="password" name="password">
    <br>
    <input type="submit" value="Registrar">
    <h1>${message}</h1>
</form>

<a href="login">Volver a Iniciar Sesión</a>

</body>
</html>
