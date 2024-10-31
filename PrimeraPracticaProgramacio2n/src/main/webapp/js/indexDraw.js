const $canvas = document.querySelector("#canvas");
const $cuadrado = document.querySelector("#cuadrado");
const $circulo = document.querySelector("#circulo");
const $triangulo = document.querySelector("#triangulo");
const $estrella = document.querySelector("#estrella");
const $draw = document.querySelector("#draw");

const ctx = $canvas.getContext("2d");
let figura = null;

const allFigures = {
  cuadrado: "cuadrado",
  circulo: "circulo",
  triangulo: "tringulo",
  estrella: "estrella",
  draw: "draw",
};

$cuadrado.addEventListener("click", () => {
  figura = allFigures.cuadrado;
});

$canvas.addEventListener("click", (event) => {
  if (figura === null) {
    return;
  }
  if (figura === allFigures.cuadrado) {
    drawCuadrado(event);
  }
});

function drawCuadrado(event) {
    const x = event.clientX
    const y = event.clientY 
    const height = 10;
    const width = 10; 
    ctx.rect(x, y, width, height)
    ctx.stroke();
}