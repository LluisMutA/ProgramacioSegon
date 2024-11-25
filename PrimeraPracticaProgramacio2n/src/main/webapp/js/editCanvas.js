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
const $figuresJSON = document.querySelector("#figuresJSON");
const $editButton = document.querySelector("#editButton");

let figurasEdit = JSON.parse($figuresJSON.innerText);

let strokeColor = $strokeColor.value;
let fillColor = $fillColor.value;
let backgroundColor = "#FFFFFF";
let figuras = figurasEdit;
let selectedFigure = null;
let editStartX = null;
let editStartY = null;
let editEndX = null;
let editEndY = null;
let isDragging = false;

// Hay que poner un else en los event listener del raton,
// para poder comprobar si estamos en modo dibujo o editar.
// Falta poner boton para volver al modo dibujo
// Falta la logica para saber cuando has clicado una figura
// Hay que actualizar la lista cada vez que se mueva una figura
// hay que llamar a redibujar canvas en addFigura (creo) para que si hay cambios se apliquen
// Cuando se clica una figura se mueve desde el centro de esta

// function isInsideFigura(*falta pasarle las cosas*) {
//   switch (figura.tipo) {
//     case "cuadrado":
//       return (

//       );
//     case "circulo":
//       return (

//       );
//     case "triangulo":

//       return (
//       );
//     case "estrella":
//     return (
//     );
//     case "draw":
//     return (
//     );
//   }
// }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
  localStorage.setItem("figurasDibujo", JSON.stringify(figuras));
}

$strokeColor.addEventListener("input", () => {
  if (selectedFigure !== null && figura === allFigures.unselected) {
    selectedFigure.strokeColor = $strokeColor.value;
    console.log(selectedFigure);
    redibujarCanvas();
    actualizarLista();
    localStorage.setItem("figurasDibujo", JSON.stringify(figuras));
    return;
  }
  strokeColor = $strokeColor.value;
});

$fillColor.addEventListener("input", () => {
  if (selectedFigure !== null && figura === allFigures.unselected) {
    selectedFigure.fillColor = $fillColor.value;
    redibujarCanvas();
    actualizarLista();
    localStorage.setItem("figurasDibujo", JSON.stringify(figuras));
    return;
  }
  fillColor = $fillColor.value;
});

$setBackground.addEventListener("click", () => {
  backgroundColor = $fillColor.value; // Usa el color de relleno como fondo
  $canvas.style.backgroundColor = backgroundColor;
  $backgroundColor.value = backgroundColor;
  localStorage.setItem("backgroundColorCanvas", backgroundColor);
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
  unselected: "unselected",
};

let startX = null;
let startY = null;
let endX = null;
let endY = null;

$canvas.addEventListener("mousedown", (event) => {
  if (figura === allFigures.unselected) {
    const positionX = event.clientX - $canvas.offsetLeft;
    const positionY = event.clientY - $canvas.offsetTop;
    selectedFigure = selectFigure(positionX, positionY);
    if (selectedFigure) {
      isDragging = true;
      editStartX = positionX;
      editStartY = positionY;
    }
    return;
  }
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
  if (selectedFigure && isDragging) {
    editEndX = event.clientX - $canvas.offsetLeft;
    editEndY = event.clientY - $canvas.offsetTop;
    const distanceX = editStartX - editEndX;
    const distanceY = editStartY - editEndY;
    if (selectedFigure.tipo !== allFigures.draw) {
      const prevStartX = selectedFigure.startX;
      const prevStartY = selectedFigure.startY;
      const prevEndX = selectedFigure.endX;
      const prevEndY = selectedFigure.endY;
      selectedFigure.startX -= distanceX;
      selectedFigure.startY -= distanceY;
      selectedFigure.endX -= distanceX;
      selectedFigure.endY -= distanceY;
      redibujarCanvas();
      selectedFigure.startX = prevStartX;
      selectedFigure.startY = prevStartY;
      selectedFigure.endX = prevEndX;
      selectedFigure.endY = prevEndY;
    } else {
      const prevDrawPath = [...selectedFigure.drawPath];
      const postDrawPath = [];
      selectedFigure.drawPath.forEach((element) => {
        postDrawPath.push({
          x: element.x - distanceX,
          y: element.y - distanceY,
        });
      });
      selectedFigure.drawPath = [...postDrawPath];
      redibujarCanvas();
      selectedFigure.drawPath = [...prevDrawPath];
    }
    return;
  }
  if (!drawing || figura !== allFigures.draw) return;
  const x = event.clientX - $canvas.offsetLeft;
  const y = event.clientY - $canvas.offsetTop;
  ctx.lineTo(x, y);
  ctx.stroke();
  drawPath.push({ x, y });
});

$canvas.addEventListener("mouseup", (event) => {
  if (figura === allFigures.unselected) {
    if (selectedFigure) {
      const distanceX = editStartX - editEndX;
      const distanceY = editStartY - editEndY;
      isDragging = false;
      if (selectedFigure.tipo !== allFigures.draw) {
        selectedFigure.startX -= distanceX;
        selectedFigure.startY -= distanceY;
        selectedFigure.endX -= distanceX;
        selectedFigure.endY -= distanceY;
      } else {
        const postDrawPath = [];
        selectedFigure.drawPath.forEach((element) => {
          postDrawPath.push({
            x: element.x - distanceX,
            y: element.y - distanceY,
          });
        });
        selectedFigure.drawPath = [...postDrawPath];
      }
      redibujarCanvas();
      actualizarLista();
    }
    return;
  }
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
  addFigura(figura, startX, startY, endX, endY, null, fillColor, strokeColor);
});

$cuadrado.addEventListener("click", () => {
  figura = allFigures.cuadrado;
  selectedFigure = null;
});

$triangulo.addEventListener("click", () => {
  figura = allFigures.triangulo;
  selectedFigure = null;
});

$circulo.addEventListener("click", () => {
  figura = allFigures.circulo;
  selectedFigure = null;
});

$estrella.addEventListener("click", () => {
  figura = allFigures.estrella;
  selectedFigure = null;
});

$draw.addEventListener("click", () => {
  figura = allFigures.draw;
  selectedFigure = null;
});

$editButton.addEventListener("click", () => {
  figura = allFigures.unselected;
  selectedFigure = null;
});

function drawCuadrado() {
  ctx.fillStyle = fillColor;
  ctx.strokeStyle = strokeColor;
  ctx.beginPath();
  ctx.rect(startX, startY, endX - startX, endY - startY);
  ctx.fill();
  ctx.stroke();
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
  ctx.fill();
  ctx.stroke();
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
  scrollToBottom();
  localStorage.setItem("figurasDibujo", JSON.stringify(figuras));
}

function eliminarFigura(index) {
  figuras.splice(index, 1);
  redibujarCanvas();
  actualizarLista();
  console.log(index);
  localStorage.setItem("figurasDibujo", JSON.stringify(figuras));
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
    localStorage.setItem("figurasDibujo", JSON.stringify(figuras));
  });
}

function selectFigure(positionX, positionY) {
  const reversedFigures = figuras.slice().reverse();

  for (const bucleFigura of reversedFigures) {
    if (bucleFigura.tipo === allFigures.draw) {
      for (let i = 0; i < bucleFigura.drawPath.length - 1; i++) {
        const startX = bucleFigura.drawPath[i].x;
        const startY = bucleFigura.drawPath[i].y;
        const endX = bucleFigura.drawPath[i + 1].x;
        const endY = bucleFigura.drawPath[i + 1].y;

        if (isPointNearLine(positionX, positionY, startX, startY, endX, endY)) {
          return bucleFigura;
        }
      }
    } else if (bucleFigura.tipo === allFigures.cuadrado) {
      if (
        positionX > bucleFigura.startX &&
        positionY > bucleFigura.startY &&
        positionX < bucleFigura.endX &&
        positionY < bucleFigura.endY
      ) {
        return bucleFigura;
      }
    } else if (bucleFigura.tipo === allFigures.triangulo) {
      const ax =
        (bucleFigura.endX - bucleFigura.startX) / 2 + bucleFigura.startX;
      const ay = bucleFigura.startY;
      const bx = bucleFigura.endX;
      const by = bucleFigura.endY;
      const cx = bucleFigura.startX;
      const cy = bucleFigura.endY;

      if (isPointInTriangle(positionX, positionY, ax, ay, bx, by, cx, cy)) {
        return bucleFigura;
      }
    } else if (bucleFigura.tipo === allFigures.circulo) {
      const centerX =
        (bucleFigura.endX - bucleFigura.startX) / 2 + bucleFigura.startX;
      const centerY =
        (bucleFigura.endY - bucleFigura.startY) / 2 + bucleFigura.startY;
      const radius = Math.abs(bucleFigura.endX - bucleFigura.startX) / 2;

      if (isPointInCircle(positionX, positionY, centerX, centerY, radius)) {
        return bucleFigura;
      }
    } else if (bucleFigura.tipo === allFigures.estrella) {
      const centerX =
        (bucleFigura.endX - bucleFigura.startX) / 2 + bucleFigura.startX;
      const centerY =
        (bucleFigura.endY - bucleFigura.startY) / 2 + bucleFigura.startY;
      const radio = Math.abs(bucleFigura.endX - bucleFigura.startX) / 2;

      const lados = 7;
      const pasos = 3;
      const estrella = lados / pasos;
      const rad = (2 * Math.PI) / estrella;

      let puntos = [];
      for (let i = 0; i < lados; i++) {
        const x = centerX + radio * Math.cos(rad * i);
        const y = centerY + radio * Math.sin(rad * i);
        puntos.push({ x, y });
      }

      for (let i = 0; i < puntos.length; i++) {
        const ax = centerX;
        const ay = centerY;
        const bx = puntos[i].x;
        const by = puntos[i].y;
        const cx = puntos[(i + 1) % puntos.length].x;
        const cy = puntos[(i + 1) % puntos.length].y;

        if (isPointInTriangle(positionX, positionY, ax, ay, bx, by, cx, cy)) {
          return bucleFigura;
        }
      }
    }
  }

  return null;
}

function isPointInTriangle(px, py, ax, ay, bx, by, cx, cy) {
  const areaOriginal = Math.abs(
    (ax * (by - cy) + bx * (cy - ay) + cx * (ay - by)) / 2
  );

  const area1 = Math.abs(
    (px * (by - cy) + bx * (cy - py) + cx * (py - by)) / 2
  );
  const area2 = Math.abs(
    (ax * (py - cy) + px * (cy - ay) + cx * (ay - py)) / 2
  );
  const area3 = Math.abs(
    (ax * (by - py) + bx * (py - ay) + px * (ay - by)) / 2
  );

  return Math.abs(areaOriginal - (area1 + area2 + area3)) < 0.01;
}

function isPointInCircle(px, py, centerX, centerY, radius) {
  const distance = Math.sqrt(
    Math.pow(px - centerX, 2) + Math.pow(py - centerY, 2)
  );
  return distance <= radius;
}

function isPointInTriangle(px, py, ax, ay, bx, by, cx, cy) {
  const areaOrig = Math.abs(
    (ax * (by - cy) + bx * (cy - ay) + cx * (ay - by)) / 2
  );
  const area1 = Math.abs(
    (px * (by - cy) + bx * (cy - py) + cx * (py - by)) / 2
  );
  const area2 = Math.abs(
    (ax * (py - cy) + px * (cy - ay) + cx * (ay - py)) / 2
  );
  const area3 = Math.abs(
    (ax * (by - py) + bx * (py - ay) + px * (ay - by)) / 2
  );

  return Math.abs(area1 + area2 + area3 - areaOrig) < 0.01;
}

function isPointNearLine(px, py, x1, y1, x2, y2, threshold = 3) {
  // 3px de tolerancia a errors
  const distance =
    Math.abs((y2 - y1) * px - (x2 - x1) * py + x2 * y1 - y2 * x1) /
    Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2));
  return distance <= threshold;
}

function scrollToBottom() {
  const listaFigurasContainer = document.querySelector(".sidebar-right");
  listaFigurasContainer.scrollTop = listaFigurasContainer.scrollHeight;
}
redibujarCanvas();
actualizarLista();
fillColor = "#FFFFFF";
strokeColor = "#000000";
