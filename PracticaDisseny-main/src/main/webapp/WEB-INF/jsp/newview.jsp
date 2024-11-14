<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:forEach var="drawing" items="${drawings}">
    <tr>
        <td>${drawing.id}</td>
        <td>${drawing.name}</td>    <!-- Accede a la propiedad name -->
        <td>${drawing.id_user}</td> <!-- Accede a la propiedad id_user -->
        <td>${drawing.user}</td>    <!-- Accede a la propiedad user -->
    </tr>
</c:forEach>
