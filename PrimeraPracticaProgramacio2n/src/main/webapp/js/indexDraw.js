const $canvas = document.querySelector("#canvas");
const $cuadrado = document.querySelector("#cuadrado");
const $circulo = document.querySelector("#circulo");
const $triangulo = document.querySelector("#triangulo");
const $estrella = document.querySelector("#estrella");
const $draw = document.querySelector("#draw");
const $clearCanvas = document.querySelector("#clearCanvas");
const $saveDraw = document.querySelector('#saveDraw');
const $drawTitle = document.querySelector('#drawTitle');
const $strokeColor = document.querySelector("#strokeColor");
const $fillColor = document.querySelector("#fillColor");
const $setBackground = document.querySelector("#setBackground");
const ctx = $canvas.getContext("2d");

let strokeColor = $strokeColor.value;
let fillColor = $fillColor.value;
let backgroundColor = "#FFFFFF";
let figuras = [];
JSON.stringify(figuras);

function addFigura(tipo, x, y, size, drawPath) {  // Falta añadir tamaño y color
  figuras.push({ tipo, x, y, size, drawPath });
  actualizarLista();
}

$strokeColor.addEventListener("input", (event) => {
  strokeColor = event.target.value;
});

$fillColor.addEventListener("input", (event) => {
  fillColor = event.target.value;
});

$setBackground.addEventListener("click", () => {
  backgroundColor = $fillColor.value; // Usa el color de relleno como fondo
  $canvas.style.backgroundColor = backgroundColor; // Cambia el color de fondo del canvas
  redibujarCanvas(); // Redibuja el canvas con el nuevo color de fondo
});

$clearCanvas.addEventListener("click", () => {
  const confirmClear = confirm("¿Estás seguro de que deseas borrar el dibujo?");
  if (confirmClear) {
    ctx.clearRect(0, 0, $canvas.width, $canvas.height);
    figuras = [];
    actualizarLista();
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

$canvas.addEventListener("click", (event) => {
  if (figura === null) {
    return;
  }
  if (figura === allFigures.cuadrado) {
    drawCuadrado(event);
  }
  if (figura === allFigures.circulo) {
    drawCirculo(event);
  }
  if (figura === allFigures.triangulo) {
    drawTriangulo(event);
  }
  if (figura === allFigures.estrella) {
    drawEstrella(event);
  }
});

$canvas.addEventListener("mousedown", (event) => {
  if (figura === allFigures.draw) {
    drawing = true;
    drawPath = [];
    ctx.beginPath();
    const x = event.clientX - $canvas.offsetLeft;
    const y = event.clientY - $canvas.offsetTop;
    ctx.moveTo(x, y);
    drawPath.push({ x, y });
  }
});

$canvas.addEventListener("mousemove", (event) => {
  if (!drawing || figura !== allFigures.draw) return;

  const x = event.clientX - $canvas.offsetLeft;
  const y = event.clientY - $canvas.offsetTop;
  ctx.lineTo(x, y);
  ctx.stroke();
  drawPath.push({ x, y });
});

$canvas.addEventListener("mouseup", () => {
  if (drawing && figura === allFigures.draw) {
    addFigura("draw", null, null, null, drawPath);
  }
  drawing = false;
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

function drawCuadrado(event) {
  const x = event.clientX - $canvas.offsetLeft;
  const y = event.clientY - $canvas.offsetTop;
  const size = 10;
  ctx.fillStyle = fillColor;
  ctx.strokeStyle = strokeColor;
  ctx.beginPath();
  ctx.rect(x - size / 2, y - size / 2, size, size);
  ctx.fill(); // Rellena el cuadrado
  ctx.stroke(); // Dibuja el borde
  addFigura("cuadrado", x, y, size);
}

function drawCirculo(event) {
  const x = event.clientX - $canvas.offsetLeft;
  const y = event.clientY - $canvas.offsetTop;
  const radio = 30;
  ctx.fillStyle = fillColor;
  ctx.strokeStyle = strokeColor;
  ctx.beginPath();
  ctx.arc(x, y, radio, 0, 2 * Math.PI);
  ctx.fill(); // Rellena el círculo
  ctx.stroke(); // Dibuja el borde
  addFigura("circulo", x, y, radio);
}

function drawTriangulo(event) {
  const x = event.clientX - $canvas.offsetLeft;
  const y = event.clientY - $canvas.offsetTop;
  const size = 20;
  ctx.fillStyle = fillColor;
  ctx.strokeStyle = strokeColor;
  ctx.beginPath();
  ctx.moveTo(x, y - size);
  ctx.lineTo(x - size, y + size);
  ctx.lineTo(x + size, y + size);
  ctx.closePath();
  ctx.fill(); // Rellena el triángulo
  ctx.stroke(); // Dibuja el borde
  addFigura("triangulo", x, y, size);
}

function drawEstrella(event) {
  const x = event.clientX - $canvas.offsetLeft;
  const y = event.clientY - $canvas.offsetTop;
  const radioExterior = 40;
  const radioInterior = 20;
  const puntas = 7;

  ctx.fillStyle = fillColor;
  ctx.strokeStyle = strokeColor;
  ctx.beginPath();
  for (let i = 0; i < puntas * 2; i++) {
    const radio = i % 2 === 0 ? radioExterior : radioInterior;
    const angulo = (i * Math.PI) / puntas;
    const px = x + radio * Math.cos(angulo);
    const py = y + radio * Math.sin(angulo);
    if (i === 0) {
      ctx.moveTo(px, py);
    } else {
      ctx.lineTo(px, py);
    }
  }
  ctx.closePath();
  ctx.fill(); // Rellena la estrella
  ctx.stroke(); // Dibuja el borde
  addFigura("estrella", x, y, radioExterior);
}

function actualizarLista() {
  const $listaFiguras = document.querySelector("#listaFiguras");
  $listaFiguras.innerHTML = "";

  figuras.forEach((figura, index) => {
    const $item = document.createElement("li");
    $item.textContent = `${figura.tipo} en (${figura.x}, ${figura.y})`;

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
}

function redibujarCanvas() {
  ctx.fillStyle = backgroundColor; // Usa el color de fondo actual
  ctx.fillRect(0, 0, $canvas.width, $canvas.height); // Rellena el canvas con el color de fondo

  figuras.forEach(figura => {
    ctx.fillStyle = fillColor; // Aplica el color de relleno
    ctx.strokeStyle = strokeColor; // Aplica el color de trazo

    switch (figura.tipo) {
      case "cuadrado":
        ctx.beginPath();
        ctx.rect(figura.x - figura.size / 2, figura.y - figura.size / 2, figura.size, figura.size);
        ctx.fill(); // Rellena el cuadrado
        ctx.stroke(); // Dibuja el borde
        break;
      case "circulo":
        ctx.beginPath();
        ctx.arc(figura.x, figura.y, figura.size, 0, 2 * Math.PI);
        ctx.fill(); // Rellena el círculo
        ctx.stroke(); // Dibuja el borde
        break;
      case "triangulo":
        ctx.beginPath();
        ctx.moveTo(figura.x, figura.y - figura.size);
        ctx.lineTo(figura.x - figura.size, figura.y + figura.size);
        ctx.lineTo(figura.x + figura.size, figura.y + figura.size);
        ctx.closePath();
        ctx.fill(); // Rellena el triángulo
        ctx.stroke(); // Dibuja el borde
        break;
      case "draw":
        ctx.beginPath();
        figura.drawPath.forEach((point, index) => {
          if (index === 0) {
            ctx.moveTo(point.x, point.y);
          } else {
            ctx.lineTo(point.x, point.y);
          }
        });
        ctx.stroke(); // Dibuja el trazo
        break;
      case "estrella":
        dibujarEstrella(figura.x, figura.y, figura.size);
        break;
    }
  });
}


function dibujarEstrella(x, y, size) {
  const radioExterior = size;
  const radioInterior = size / 2;
  const puntas = 7;

  ctx.beginPath();
  for (let i = 0; i < puntas * 2; i++) {
    const radio = i % 2 === 0 ? radioExterior : radioInterior;
    const angulo = (i * Math.PI) / puntas;
    const px = x + radio * Math.cos(angulo);
    const py = y + radio * Math.sin(angulo);
    if (i === 0) {
      ctx.moveTo(px, py);
    } else {
      ctx.lineTo(px, py);
    }
  }
  ctx.closePath();
  ctx.stroke();
}

function scrollToBottom() {
  const listaFigurasContainer = document.querySelector('.sidebar-right');
  listaFigurasContainer.scrollTop = listaFigurasContainer.scrollHeight;
}
