<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registro</title>
</head>
<body>
    <h2>Formulario de Registro</h2>
    <form action="register" method="post">

        <label for="name">Nombre:</label>
        <input type="text" id="name" name="name">
        <br><br>

        <label for="username">Nombre de Usuario:</label>
        <input type="text" id="username" name="username">
        <br><br>

        <label for="password">Contraseña:</label>
        <input type="password" id="password" name="password">
        <br><br>

        <label for="passwordCheck">Confirma la Contraseña:</label>
        <input type="password" id="passwordCheck" name="passwordCheck">
        <br><br>

        <button type="submit">Registrarse</button>
    </form>

    <div id="message" style="color: red;">
        <% String message = (String) request.getAttribute("message"); %>
        <% if (message != null) { %>
            <p><%= message %></p>
        <% } %>
    </div>
</body>
</html>
