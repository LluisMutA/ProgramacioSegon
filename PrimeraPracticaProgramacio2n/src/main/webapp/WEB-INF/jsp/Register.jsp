<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registro</title>
    <link rel="stylesheet" href="./css/register.css"> 
</head>
<body>
    <div class="registration-container">
        <h2>Formulario de Registro</h2>
        <form action="register" method="post">
            <label for="name">Nombre:</label>
            <input type="text" id="name" name="name" required>

            <label for="username">Nombre de Usuario:</label>
            <input type="text" id="username" name="username" required>

            <label for="password">Contraseña:</label>
            <input type="password" id="password" name="password" required>

            <label for="passwordCheck">Confirma la Contraseña:</label>
            <input type="password" id="passwordCheck" name="passwordCheck" required>

            <button type="submit">Registrarse</button>
        </form>

        <div id="message">
            <% String message = (String) request.getAttribute("message"); %>
            <% if (message != null) { %>
                <p><%= message %></p>
            <% } %>
        </div>
    </div>
</body>
</html>

