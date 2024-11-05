<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>Canvas View</title>
    <link rel="stylesheet" href="./css/viewDraw.css"> <!-- Asegúrate de incluir el CSS -->
    <script type="application/json" id="figuresJSON">${figures}</script>
    <script src="./js/viewCanvas.js" defer></script>
  </head>
  <body>
    <h1>Title: ${drawTitle}</h1>
    <h2>Author: ${author}</h2>
    <canvas id="canvas" style="background-color: ${backgroundColor};" width="500" height="500"></canvas>
  </body>
</html>
