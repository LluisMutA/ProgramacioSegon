<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Dibujo</title>
    <script src="/js/editCanvas.js" defer></script>
</head>
<body>
    <h1>Editando: ${drawTitle}</h1>
    <canvas id="canvas" width="500" height="500" style="border:1px solid #000;"></canvas>
    <textarea id="figuresJSON" hidden>${figures}</textarea>
     <form method="post" action="/save-draw">
            <input type="hidden" name="drawId" value="${drawId}">
            <textarea name="figures" id="figures">${figures}</textarea>
            <button type="submit">Guardar Cambios</button>
        </form>
    <button id="saveButton">Guardar Cambios</button>
</body>
</html>
