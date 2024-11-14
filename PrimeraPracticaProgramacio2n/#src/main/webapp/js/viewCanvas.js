const $canvas = document.querySelector("#canvas");
const ctx = $canvas.getContext("2d");
const $figuresJSON = document.querySelector("#figuresJSON");

let figuras = JSON.parse($figuresJSON.innerText);

let strokeColor = "#000000";
let fillColor = "#FFFFFF";
let startX = null;
let startY = null;
let endX = null;
let endY = null;

function drawCuadrado() {
    ctx.fillStyle = fillColor;
    ctx.strokeStyle = strokeColor;
    ctx.beginPath();
    ctx.rect(startX, startY, endX - startX, endY - startY);
    ctx.fill(); // Rellena el cuadrado
    ctx.stroke(); // Dibuja el borde
  }
  
  function drawCirculo() {
    const radioX = Math.abs(endX - startX) / 2;
    const radioY = Math.abs(endY - startY) / 2;
    const centerX = (endX - startX) / 2 + startX;
    const centerY = (endY - startY) / 2 + startY;
  
    ctx.fillStyle = fillColor;
    ctx.strokeStyle = strokeColor;
    ctx.beginPath();
    ctx.ellipse(centerX, centerY, radioX, radioY, 0, 0, 2 * Math.PI);
    ctx.fill();
    ctx.stroke();
  }
  
  function drawTriangulo() {
    ctx.fillStyle = fillColor;
    ctx.strokeStyle = strokeColor;
    ctx.beginPath();
    ctx.moveTo((endX - startX) / 2 + startX, startY);
    ctx.lineTo(endX, endY);
    ctx.lineTo(startX, endY);
    ctx.lineTo((endX - startX) / 2 + startX, startY);
    ctx.closePath();
    ctx.fill(); // Rellena el triángulo
    ctx.stroke(); // Dibuja el borde
  }
  
  function drawEstrella() {
    ctx.fillStyle = fillColor;
    ctx.strokeStyle = strokeColor;
    const radio = Math.abs(endX - startX) / 2;
    const centerX = (endX - startX) / 2 + startX;
    const centerY = (endY - startY) / 2 + startY;
  
    const lados = 7;
    const pasos = 3;
  
    const estrella = lados / pasos;
    const rad = (2 * Math.PI) / estrella;

    ctx.beginPath();
    for (let i = 0; i < lados; i++) {
      const x = centerX + radio * Math.cos(rad * i);
      const y = centerY + radio * Math.sin(rad * i);
      ctx.lineTo(x, y);
    }
    ctx.closePath();
    ctx.stroke();
    ctx.fill();
  }

function redibujarCanvas() {
    ctx.clearRect(0, 0, $canvas.width, $canvas.height); 
  
    figuras.forEach((figura) => {
      fillColor = figura.fillColor; // Usa el color de relleno de la figura
      strokeColor = figura.strokeColor; // Usa el color de trazo de la figura
  
      startX = figura.startX;
      startY = figura.startY;
      endX = figura.endX;
      endY = figura.endY;
  
      switch (figura.tipo) {
        case "cuadrado":
          drawCuadrado();
          break;
        case "circulo":
          drawCirculo();
          break;
        case "triangulo":
          drawTriangulo();
          break;
        case "draw":
          ctx.beginPath();
          ctx.strokeStyle = strokeColor; 
  
          figura.drawPath.forEach((point, index) => {
            if (index === 0) {
              ctx.moveTo(point.x, point.y);
            } else {
              ctx.lineTo(point.x, point.y);
            }
  
          });
          ctx.stroke();
          break;
        case "estrella":
          drawEstrella();
          break;
      }
    });
  }
  redibujarCanvas();