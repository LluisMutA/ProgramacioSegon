<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="./css/login-style.css">
</head>
<body>
    <div class="login-container">
        <form method="post">
            <label for="username">Usuario:</label>
            <input type="text" name="username" id="username" required>
            
            <label for="password">Contraseña:</label>
            <input type="password" name="password" id="password" required>
            
            <input type="submit" value="Ingresar">
            
            <h1>${message}</h1>
        </form>
        <a href="/register" class="register-link">¿Nuevo usuario?</a>
    </div>
</body>
</html>