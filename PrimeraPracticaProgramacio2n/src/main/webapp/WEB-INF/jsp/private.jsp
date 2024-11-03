<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
    <link rel="stylesheet" href="./css/style.css">
    <script defer src="./js/indexDraw.js"></script>
</head>

<body>
    <!-- Barra de navegación superior -->
    <div class="navbar">
        <h1>Private</h1>
        <div>Benvingut ${username}</div>
        <a href="/logout">Cerrar Sesión</a>
    </div>

    <!-- Contenedor principal -->
    <div class="container">
        <!-- Botones a la izquierda -->
        <div class="sidebar-left">
            <button id="cuadrado">Cuadrado</button>
            <button id="triangulo">Triangulo</button>
            <button id="circulo">Circulo</button>
            <button id="estrella">Estrella</button>
            <button id="draw">Draw</button>
        </div>

        <!-- Canvas en el centro -->
        <div class="canvas-container">
            <canvas id="canvas" width="500" height="500"></canvas>
        </div>

        <!-- Lista de figuras a la derecha -->
        <div class="sidebar-right">
            <ul id="listaFiguras"></ul>
        </div>
    </div>

    <!-- Contenedor para los botones de guardar y borrar debajo del canvas -->
    <div class="save-container">
        <form method="post" action="/save-draw">
            <input type="hidden" name="saveDraw" id="saveDraw">
            <label for="drawTitle">Nombre del dibujo: </label>
            <input type="text" name="drawTitle" id="drawTitle">
            <button type="submit">Guardar Dibujo</button>
        </form>
        <button id="clearCanvas">Borrar Todo</button>
    </div>
</body>

</html>
