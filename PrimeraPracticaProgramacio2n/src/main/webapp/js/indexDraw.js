const $canvas = document.querySelector("#canvas");
const $cuadrado = document.querySelector("#cuadrado");
const $circulo = document.querySelector("#circulo");
const $triangulo = document.querySelector("#triangulo");
const $estrella = document.querySelector("#estrella");
const $draw = document.querySelector("#draw");
const $clearCanvas = document.querySelector("#clearCanvas");
const $saveDraw = document.querySelector("#saveDraw");
const $drawTitle = document.querySelector("#drawTitle");
const $strokeColor = document.querySelector("#strokeColor");
const $fillColor = document.querySelector("#fillColor");
const $setBackground = document.querySelector("#setBackground");
const ctx = $canvas.getContext("2d");
const $backgroundColor = document.querySelector("#backgroundColor");


let strokeColor = $strokeColor.value;
let fillColor = $fillColor.value;
let backgroundColor = "#FFFFFF";
let figuras = [];

function addFigura(
  tipo,
  startX,
  startY,
  endX,
  endY,
  drawPath,
  fillColor,
  strokeColor
) {
  figuras.push({
    tipo,
    startX,
    startY,
    endX,
    endY,
    drawPath,
    fillColor,
    strokeColor,
  });
  actualizarLista();
}


$strokeColor.addEventListener("input", () => {
  strokeColor = $strokeColor.value;
});

$fillColor.addEventListener("input", () => {
  fillColor = $fillColor.value;
});

$setBackground.addEventListener("click", () => {
  backgroundColor = $fillColor.value; // Usa el color de relleno como fondo
  $canvas.style.backgroundColor = backgroundColor;
  $backgroundColor.value = backgroundColor;
});

$clearCanvas.addEventListener("click", () => {
  const confirmClear = confirm("¿Estás seguro de que deseas borrar el dibujo?");
  if (confirmClear) {
    ctx.clearRect(0, 0, $canvas.width, $canvas.height);
    figuras = [];
    actualizarLista();
    backgroundColor = "#FFFFFF";
    $canvas.style.backgroundColor = backgroundColor;
  }
});

$drawTitle.value = `Untitled Draw ${Math.floor(Math.random() * 10000)}`;

let figura = null;
let drawing = false;
let drawPath = [];

const allFigures = {
  cuadrado: "cuadrado",
  circulo: "circulo",
  triangulo: "triangulo",
  estrella: "estrella",
  draw: "draw",
};

let startX = null;
let startY = null;
let endX = null;
let endY = null;

$canvas.addEventListener("mousedown", (event) => {
  ctx.strokeStyle = strokeColor;
  if (figura === allFigures.draw) {
    drawing = true;
    drawPath = [];
    ctx.beginPath();
    const x = event.clientX - $canvas.offsetLeft;
    const y = event.clientY - $canvas.offsetTop;
    ctx.moveTo(x, y);
    drawPath.push({ x, y });
    return;
  }
  startX = event.clientX - $canvas.offsetLeft;
  startY = event.clientY - $canvas.offsetTop;
});

$canvas.addEventListener("mousemove", (event) => {
  if (!drawing || figura !== allFigures.draw) return;
  const x = event.clientX - $canvas.offsetLeft;
  const y = event.clientY - $canvas.offsetTop;
  ctx.lineTo(x, y);
  ctx.stroke();
  drawPath.push({ x, y });
});

$canvas.addEventListener("mouseup", (event) => {
  if (drawing && figura === allFigures.draw) {
    addFigura("draw", null, null, null, null, drawPath, fillColor, strokeColor);
    drawing = false;
    return;
  }
  endX = event.clientX - $canvas.offsetLeft;
  endY = event.clientY - $canvas.offsetTop;
  if (figura === null) {
    return;
  }
  if (figura === allFigures.cuadrado) {
    drawCuadrado();
  }
  if (figura === allFigures.circulo) {
    drawCirculo();
  }
  if (figura === allFigures.triangulo) {
    drawTriangulo();
  }
  if (figura === allFigures.estrella) {
    drawEstrella();
  }
  addFigura(
    figura,
    startX,
    startY,
    endX,
    endY,
    null,
    fillColor,
    strokeColor
  );
});

$cuadrado.addEventListener("click", () => {
  figura = allFigures.cuadrado;
});

$triangulo.addEventListener("click", () => {
  figura = allFigures.triangulo;
});

$circulo.addEventListener("click", () => {
  figura = allFigures.circulo;
});

$estrella.addEventListener("click", () => {
  figura = allFigures.estrella;
});

$draw.addEventListener("click", () => {
  figura = allFigures.draw;
});

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

  // ctx.rotate((3 * Math.PI) / 2);
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

function actualizarLista() {
  const $listaFiguras = document.querySelector("#listaFiguras");
  $listaFiguras.innerHTML = "";

  figuras.forEach((figura, index) => {
    
    const $item = document.createElement("li");
    $item.textContent = `${figura.tipo} en (${figura.startX}, ${figura.startY})`;

    const $deleteButton = document.createElement("button");
    $deleteButton.textContent = "Borrar";
    $deleteButton.addEventListener("click", () => eliminarFigura(index));

    $item.appendChild($deleteButton);
    $listaFiguras.appendChild($item);
  });

  $saveDraw.value = JSON.stringify(figuras);
  scrollToBottom(); // Desplaza hacia el último elemento agregado
}

function eliminarFigura(index) {
  figuras.splice(index, 1);
  redibujarCanvas();
  actualizarLista();
  console.log(index);
}

function redibujarCanvas() {
  ctx.clearRect(0, 0, $canvas.width, $canvas.height); 

  // Redibuja cada figura encima del fondo
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
function scrollToBottom() {
  const listaFigurasContainer = document.querySelector(".sidebar-right");
  listaFigurasContainer.scrollTop = listaFigurasContainer.scrollHeight;
}
