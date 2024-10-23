<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post">
    <div>
        Num: A
        <input type= "number" name="na">
    </div>
    <div>
        Num: B
        <input type= "number" name="nb">
    </div>
     <div>
           <label for="operacio">Operació:</label>
           <select name="operacio">
                <option value="suma">Suma</option>
                <option value="resta">Resta</option>
                <option value="mult">Multiplicació</option>
                <option value="div">Divisió</option>
           </select>
        </div>
    <div>
        <input type = "submit" name="Opera">
    </div>
</form>

<c:if test="${not empty message}">
    <div> ERROR: ${message} </div>
</c:if>

<c:if test="${not empty resultat && empty message}">
<div>
    El resultat és: ${resultat}
</div>
</c:if>


</form>
</body>
</html>
