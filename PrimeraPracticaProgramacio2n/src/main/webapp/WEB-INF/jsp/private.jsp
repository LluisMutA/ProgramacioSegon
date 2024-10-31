<%@ page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>

            <html>

            <head>
                <title>Title</title>
                <script defer src="./js/indexDraw.js"></script>
            </head>

            <body>

                <h1>Private</h1>
                <div>Benvingut ${username}</div>
                <a href="/logout">Cerrar Sesión</a>

                <div><canvas id="canvas" width="800" height="800"></canvas></div>
                <div>
                    <button id="cuadrado">Cuadrado</button>
                    <button id="triangulo">Triangulo</button>
                    <button id="circulo">Circulo</button>
                    <button id="estrella">Estrella</button>
                    <button id="draw">Draw</button>
                </div>

                <style>
                    #canvas {
                        border: 1px solid black;
                    }
                </style>

            </body>

            </html>