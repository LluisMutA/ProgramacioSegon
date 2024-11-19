const $canvas = document.querySelector("#canvas");
const ctx = $canvas.getContext("2d");
const $figuresJSON = document.querySelector("#figuresJSON");
const $saveButton = document.querySelector("#saveButton");

let figuras = JSON.parse($figuresJSON.innerText);

redibujarCanvas();

$saveButton.addEventListener("click", () => {
    const updatedFigures = JSON.stringify(figuras);

    fetch("/save-edited-draw", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            drawTitle: document.querySelector("h1").innerText,
            backgroundColor: document.body.style.backgroundColor,
            saveDraw: updatedFigures,
        }),
    })
        .then((response) => {
            if (response.ok) {
                alert("Dibujo guardado exitosamente");
                window.location.href = "/private";
            } else {
                alert("Error al guardar el dibujo");
            }
        })
        .catch((error) => {
            console.error("Error:", error);
        });
});
