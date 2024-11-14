<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <script defer src="./js/draw.js"></script>
    <title>Dibujo en Canvas</title>
    <style>
        body {
            display: flex;
            justify-content: space-between;
        }
        canvas {
            border: 1px solid black;
        }
        #historial {
            margin-top: 20px;
            width: 200px;
            list-style-type: none;
            padding: 0;
            overflow-y: auto; /* Scroll vertical */
            max-height: 300px; /* Altura máxima para el historial */
        }
        #historial div {
            margin-bottom: 5px;
            cursor: default; /* Cambiado para indicar que no es movible */
            border: 1px solid #ccc;
            padding: 5px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            width: 100%; /* Ocupa todo el ancho del contenedor */
        }
        .delete-button {
            background-color: red;
            color: white;
            border: none;
            cursor: pointer;
            padding: 2px 5px;
            border-radius: 3px;
        }
        .mini-canvas {
            width: 30px;
            height: 30px;
            border: 1px solid #ccc;
            margin-right: 5px;
        }
    </style>
</head>
<body>
    <h1>Dibujo en Canvas</h1>
    <div>
        <canvas id="miCanvas" width="500" height="500"></canvas>
        <br>
        <button onclick="clearCanvas()">Limpiar Canvas</button>
        <button onclick="window.location.href='dashboard'">Volver al Dashboard</button>
        <button onclick="saveCanvas()">Guardar Dibujo</button>
        <button onclick="setShape('square')">Dibujar Cuadrado</button>
        <button onclick="setShape('circle')">Dibujar Círculo</button>
        <button onclick="setShape('triangle')">Dibujar Triángulo</button>
        <button onclick="setShape('star')">Dibujar Estrella</button>
        <button onclick="setShape('free')">Dibujar a Mano Alzada</button>
        <button id="moveButton" onmousedown="toggleMove(true)" onmouseup="toggleMove(false)">Mover</button>
        <button onclick="clearHistory()">Borrar Historial</button>
        <br><br>

        <label for="size">Tamaño de figuras y trazo: </label>
        <input type="range" id="size" min="1" max="100" value="50" onchange="updateSize()">
        <br>
            <form id="saveForm" action="saveDrawing" method="POST" style="display:none;">
                <input type="hidden" name="drawingData" id="dataJson">
            </form>

        <label for="colorPicker">Color de figuras y trazo:</label>
        <input type="color" id="colorPicker" value="#000000" onchange="updateColors()"> <!-- Color por defecto negro -->
    </div>

    <div id="historial"></div>
</body>
</html>
