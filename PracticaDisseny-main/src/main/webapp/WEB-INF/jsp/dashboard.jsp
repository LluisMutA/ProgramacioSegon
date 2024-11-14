<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
</head>
<body>
    <h1>Bienvenido al Dashboard</h1>
    <h2>Dibujos Guardados</h2>
    <table>
        <thead>
            <tr>
                <th>Nombre del Dibujo</th>
                <th>ID Usuario</th>
                <th>Nombre Usuario</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="drawing" items="${drawings}">
                <tr>
                    <td>${drawing.name}</td>
                    <td>${drawing.id_user}</td>
                    <td>${drawing.user}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <button onclick="window.location.href='logoutServlet'">Logout</button>
    <button onclick="window.location.href='draw'">Ir a Draw</button>
</body>
</html>
