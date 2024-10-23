<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test="${temp > 25}">
    <div>Fa calor</div>
</c:if>

<c:if test="${temp <= 25}">
    <div>Fa fred</div>
</c:if>
<div>Tens ${money} EUROS</div>

<c:choose>
    <c:when test="${money >= 1000000}">
        <div>Ets millonari</div>
    </c:when>
    <c:when test=${money >= 100000}>
        <div>Vius be </div>
    </c:when>
    <c:otherwise>
        <div>Ets pobre</div>
    </c:otherwise>
</c:choose>

<c:forEach items="${cls}" var="dt">
    <div>
        <span>Dia: ${dt.key}</span>
        <span>Hores: ${dt.value}</span>
    </div>
</c:forEach>

<div>
    Person name: ${pep.nom}
</div>
<div>
    Person birthYear: ${pep.birthYear}
</div>

</body>
</html>
