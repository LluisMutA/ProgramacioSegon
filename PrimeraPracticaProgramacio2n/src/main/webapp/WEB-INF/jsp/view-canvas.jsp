<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>Canvas View</title>
    <link rel="stylesheet" href="./css/viewDraw.css">
    <script type="application/json" id="figuresJSON">${figures}</script>
    <script src="./js/viewCanvas.js" defer></script>
  </head>
  <body>
    <h1>Title: ${drawTitle}</h1>
    <h2>Author: ${author}</h2>
    <h3>ID: ${drawId}</h3>
    <canvas id="canvas" style="background-color: ${backgroundColor};" width="500" height="500"></canvas>

    <button onclick="location.href='/draw-gallery'">
                Ir a la Galería
                <img src="./images/gallery.png" alt="">
            </button>
            <button onclick="location.href='/owned-gallery'">
                Mis dibujos:
            </button>
            <button onclick="location.href='/private'">
                Volver al canvas:
            </button>
  </body>
</html>
