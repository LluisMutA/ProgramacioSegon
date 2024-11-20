<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
    <link rel="stylesheet" href="./css/style.css">
    <script type="application/json" id="figuresJSON">${figures}</script>
    <script defer src="./js/editCanvas.js"></script>
</head>

<body>
    <div class="navbar">
        <h1>Private</h1>
        <div>Modificando: ${drawTitle} con id: ${drawId}</div>
        <a href="/logout">Cerrar Sesión</a>
    </div>

    <div class="container">

        <div class="sidebar-left">
            <button id="cuadrado">
                <img src="./images/cuadrado.png" alt="Cuadrado" > Cuadrado
            </button>
            <button id="triangulo">
                <img src="./images/triangulo.png" alt="Triangulo"> Triangulo
            </button>
            <button id="circulo">
                <img src="./images/circulo.png" alt="Circulo"> Circulo
            </button>
            <button id="estrella">
                <img src="./images/estrella.png" alt="Estrella"> Estrella
            </button>
            <button id="draw">
                <img src="./images/draw.png" alt="Draw"> Draw
            </button>

            <input type="color" id="strokeColor" value="#000000">
            <input type="color" id="fillColor" value="#FFFFFF">
            <button id="setBackground">Fondo Canvas</button>
        </div>

        <div class="canvas-container">
            <canvas id="canvas" width="500" height="500"></canvas>
        </div>

        <div class="sidebar-right"Lista de figuras:>
            <ul id="listaFiguras"></ul>
        </div>
    </div>

    <div class="save-container">
        <form method="post" action="/save-draw">
            <input type="hidden" name="saveDraw" id="saveDraw">
            <label for="drawTitle">Nombre del dibujo: </label>
            <input type="text" name="drawTitle" id="drawTitle">
            <button type="submit">
                Guardar Dibujo
                <img src="./images/saveDraw.png" alt="Guardar">
            </button>
            <input type="hidden" name="backgroundColor" id="backgroundColor" value="#FFFFFF">
        </form>
        <button id="clearCanvas">
            Borrar Todo
            <img src="./images/clearCanvas.png" alt="Borrar">
        </button>
        <button onclick="location.href='/draw-gallery'">
            Ir a la Galería
            <img src="./images/gallery.png" alt="">
        </button>
        <button onclick="location.href='/owned-gallery'">
            Mis dibujos:
        </button>

    </div>

</body>

</html>
