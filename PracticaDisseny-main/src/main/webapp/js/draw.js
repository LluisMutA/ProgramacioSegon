
        const canvas = document.getElementById('miCanvas');
        const ctx = canvas.getContext('2d');

        let currentShape = null;
        let isDrawing = false;
        let lastX = 0;
        let lastY = 0;
        let shapes = [];
        let shapeSize = 50;
        let fillColor = '#000000'; // Color por defecto negro
        let currentStrokeColor = '#000000'; // Color por defecto negro para el trazo
        let isMoving = false; // Estado de mover
        let selectedShape = null; // Forma seleccionada para mover
        let offsetX, offsetY; // Desplazamiento para mover

        function setShape(shape) {
            currentShape = shape;
            isDrawing = false; // Desactivar dibujo al cambiar forma
        }

        canvas.addEventListener('mousedown', (e) => {
            const { x, y } = getMousePos(e);
            if (isMoving) {
                selectShape(x, y); // Intentar seleccionar una figura
                if (selectedShape) {
                    offsetX = x - selectedShape.x; // Calcular desplazamiento
                    offsetY = y - selectedShape.y;
                }
            } else if (currentShape === 'free') {
                isDrawing = true;
                [lastX, lastY] = [x, y];
                shapes.push({ type: 'free', points: [{ x: lastX, y: lastY }], shapeSize: shapeSize, strokeColor: currentStrokeColor });
            } else {
                drawShape(x, y);
            }
        });

        canvas.addEventListener('mouseup', () => {
            if (isDrawing && currentShape === 'free') {
                updateHistory();
            }
            isDrawing = false;
            selectedShape = null; // Desmarcar forma seleccionada al soltar el ratón
        });

        canvas.addEventListener('mousemove', (e) => {
            if (isDrawing && currentShape === 'free') {
                const newX = e.offsetX;
                const newY = e.offsetY;
                drawSmoothLine(lastX, lastY, newX, newY, shapeSize);
                shapes[shapes.length - 1].points.push({ x: newX, y: newY });
                [lastX, lastY] = [newX, newY];
            } else if (isMoving) {
                // Mover la figura seleccionada o el trazo a mano alzada
                if (selectedShape) {
                    selectedShape.x = e.offsetX - offsetX;
                    selectedShape.y = e.offsetY - offsetY;
                } else {
                    moveFreeDraw(e.offsetX, e.offsetY);
                }
                redrawCanvas();
            }
        });

        function getMousePos(evt) {
            const rect = canvas.getBoundingClientRect();
            return {
                x: evt.clientX - rect.left,
                y: evt.clientY - rect.top
            };
        }

        function clearCanvas() {
            ctx.clearRect(0, 0, canvas.width, canvas.height);
            shapes = [];
            updateHistory();
        }


              function saveCanvas() {
                  const dataURL = document.getElementById('miCanvas').toDataURL();

                  const drawing = {
                      id: 1,
                      name: "GERVASIO",
                      user: "nombreUsuario",
                      id_user: 123,
                      //drawingData: dataURL
                  };

                  const dataJson = JSON.stringify(drawing);
                  document.getElementById('dataJson').value = dataJson;
                  document.getElementById('saveForm').submit();
              }

function drawShape(x, y) {
    switch (currentShape) {
        case 'square':
            drawSquare(x, y);
            break;
        case 'circle':
            drawCircle(x, y);
            break;
        case 'star':
            drawStar(x, y);
            break;
        case 'triangle':
            drawTriangle(x, y);
            break;
        default:
            break;
    }
}


        function drawSquare(x, y) {
            const shape = { type: 'square', x: x - shapeSize / 2, y: y - shapeSize / 2, size: shapeSize, fillColor: fillColor };
            shapes.push(shape);
            ctx.fillStyle = fillColor;
            ctx.fillRect(shape.x, shape.y, shape.size, shape.size);
            updateHistory();
        }

        function drawCircle(x, y) {
            const shape = { type: 'circle', x: x, y: y, radius: shapeSize / 2, fillColor: fillColor };
            shapes.push(shape);
            ctx.fillStyle = fillColor;
            ctx.beginPath();
            ctx.arc(shape.x, shape.y, shape.radius, 0, Math.PI * 2);
            ctx.fill();
            updateHistory();
        }

        function drawTriangle(x, y) {
            const shape = {
                type: 'triangle',
                x: x, // Punto central de la base
                y: y, // Vértice superior
                size: shapeSize, // Tamaño de los lados del triángulo
                fillColor: fillColor
            };
            shapes.push(shape);

            // Altura del triángulo equilátero
            const height = shape.size * Math.sqrt(3) / 2;

            // Dibujar el triángulo en el canvas
            ctx.fillStyle = fillColor;
            ctx.beginPath();

            // Vértice superior
            ctx.moveTo(shape.x, shape.y - height / 2);

            // Vértice inferior izquierdo
            ctx.lineTo(shape.x - shape.size / 2, shape.y + height / 2);

            // Vértice inferior derecho
            ctx.lineTo(shape.x + shape.size / 2, shape.y + height / 2);

            ctx.closePath();
            ctx.fill();

            updateHistory();
        }



        function drawStar(x, y) {
            const shape = { type: 'star', x: x, y: y, outerRadius: shapeSize / 2, innerRadius: shapeSize / 4, fillColor: fillColor };
            shapes.push(shape);
            ctx.fillStyle = fillColor;
            ctx.beginPath();
            for (let i = 0; i < 24; i++) {
                const angle = i * Math.PI / 12;
                const radius = i % 2 === 0 ? shape.outerRadius : shape.innerRadius;
                ctx.lineTo(shape.x + Math.cos(angle) * radius, shape.y + Math.sin(angle) * radius);
            }
            ctx.closePath();
            ctx.fill();
            updateHistory();
        }

        function drawSmoothLine(x1, y1, x2, y2, lineWidth) {
            ctx.strokeStyle = currentStrokeColor;
            ctx.lineWidth = lineWidth;
            ctx.lineCap = 'round';
            ctx.beginPath();
            ctx.moveTo(x1, y1);
            ctx.lineTo(x2, y2);
            ctx.stroke();
        }

        function updateHistory() {
            const historialDiv = document.getElementById('historial');
            historialDiv.innerHTML = ''; // Limpiar historial
            shapes.forEach((shape, index) => {
                const shapeDiv = document.createElement('div');
                const miniCanvas = document.createElement('canvas');
                miniCanvas.className = 'mini-canvas';
                miniCanvas.width = 30;
                miniCanvas.height = 30;

                const miniCtx = miniCanvas.getContext('2d');
                if (shape.type === 'free') {
                    miniCtx.strokeStyle = shape.strokeColor;
                    miniCtx.lineWidth = shape.shapeSize;
                    miniCtx.lineCap = 'round';
                    miniCtx.beginPath();
                    miniCtx.moveTo(shape.points[0].x / 10, shape.points[0].y / 10);
                    shape.points.forEach(point => {
                        miniCtx.lineTo(point.x / 10, point.y / 10);
                    });
                    miniCtx.stroke();
                } else if (shape.type === 'square') {
                    miniCtx.fillStyle = shape.fillColor;
                    miniCtx.fillRect(shape.x / 10, shape.y / 10, shape.size / 10, shape.size / 10);
                } else if (shape.type === 'circle') {
                    miniCtx.fillStyle = shape.fillColor;
                    miniCtx.beginPath();
                    miniCtx.arc(shape.x / 10, shape.y / 10, shape.radius / 10, 0, Math.PI * 2);
                    miniCtx.fill();
                } else if (shape.type === 'star') {
                    miniCtx.fillStyle = shape.fillColor;
                    miniCtx.beginPath();
                    for (let i = 0; i < 24; i++) {
                        const angle = i * Math.PI / 12;
                        const radius = i % 2 === 0 ? shape.outerRadius / 10 : shape.innerRadius / 10;
                        miniCtx.lineTo(shape.x / 10 + Math.cos(angle) * radius, shape.y / 10 + Math.sin(angle) * radius);
                    }
                    miniCtx.closePath();
                    miniCtx.fill();
                } else if (shape.type === 'triangle') { // Agregar este bloque para el triángulo
                    const height = shape.size * Math.sqrt(3) / 2; // Altura del triángulo equilátero
                    miniCtx.fillStyle = shape.fillColor;
                    miniCtx.beginPath();
                    miniCtx.moveTo(shape.x / 10, (shape.y - height / 2) / 10);
                    miniCtx.lineTo((shape.x - shape.size / 2) / 10, (shape.y + height / 2) / 10);
                    miniCtx.lineTo((shape.x + shape.size / 2) / 10, (shape.y + height / 2) / 10);
                    miniCtx.closePath();
                    miniCtx.fill();
                }

                shapeDiv.textContent = `Elemento ${index + 1}: ${shape.type === 'free' ? 'Trazado a Mano Alzada' : shape.type}`;
                shapeDiv.appendChild(miniCanvas);

                const deleteButton = document.createElement('button');
                deleteButton.textContent = 'Eliminar';
                deleteButton.className = 'delete-button';
                deleteButton.onclick = () => {
                    shapes.splice(index, 1);
                    updateHistory();
                };

                shapeDiv.appendChild(deleteButton);
                historialDiv.appendChild(shapeDiv);
            });
            redrawCanvas();
        }

        function redrawCanvas() {
            ctx.clearRect(0, 0, canvas.width, canvas.height); // Limpiar el canvas

            shapes.forEach(shape => {
                if (shape.type === 'free') {
                    // Dibujo a mano alzada
                    ctx.strokeStyle = shape.strokeColor;
                    ctx.lineWidth = shape.shapeSize;
                    ctx.lineCap = 'round';
                    ctx.beginPath();
                    ctx.moveTo(shape.points[0].x, shape.points[0].y);
                    shape.points.forEach(point => {
                        ctx.lineTo(point.x, point.y);
                    });
                    ctx.stroke();
                } else if (shape.type === 'square') {
                    // Dibujo de un cuadrado
                    ctx.fillStyle = shape.fillColor;
                    ctx.fillRect(shape.x, shape.y, shape.size, shape.size);
                } else if (shape.type === 'circle') {
                    // Dibujo de un círculo
                    ctx.fillStyle = shape.fillColor;
                    ctx.beginPath();
                    ctx.arc(shape.x, shape.y, shape.radius, 0, Math.PI * 2);
                    ctx.fill();
                } else if (shape.type === 'star') {
                    // Dibujo de una estrella
                    ctx.fillStyle = shape.fillColor;
                    ctx.beginPath();
                    for (let i = 0; i < 24; i++) {
                        const angle = i * Math.PI / 12;
                        const radius = i % 2 === 0 ? shape.outerRadius : shape.innerRadius;
                        ctx.lineTo(shape.x + Math.cos(angle) * radius, shape.y + Math.sin(angle) * radius);
                    }
                    ctx.closePath();
                    ctx.fill();
                } else if (shape.type === 'triangle') {
                    // Dibujo de un triángulo
                    const height = shape.size * Math.sqrt(3) / 2; // Altura del triángulo equilátero

                    ctx.fillStyle = shape.fillColor;
                    ctx.beginPath();

                    // Vértice superior
                    ctx.moveTo(shape.x, shape.y - height / 2);

                    // Vértice inferior izquierdo
                    ctx.lineTo(shape.x - shape.size / 2, shape.y + height / 2);

                    // Vértice inferior derecho
                    ctx.lineTo(shape.x + shape.size / 2, shape.y + height / 2);

                    ctx.closePath();
                    ctx.fill();
                }
            });
        }


        function clearHistory() {
            shapes = [];
            clearCanvas();
            updateHistory();
        }

        function updateSize() {
            shapeSize = document.getElementById('size').value;
            redrawCanvas();
        }

        function updateColors() {
            fillColor = document.getElementById('colorPicker').value;
            currentStrokeColor = fillColor; // Establecer el color del trazo igual al color de la figura
        }

        function toggleMove(active) {
            isMoving = active;
            selectedShape = null; // Resetear selección al cambiar estado
            const button = document.getElementById('moveButton');
            button.textContent = isMoving ? 'Detener Mover' : 'Mover'; // Cambiar texto del botón
        }

        function selectShape(x, y) {
            shapes.forEach(shape => {
                if (shape.type !== 'free' && isPointInShape(shape, x, y)) {
                    selectedShape = shape;
                }
            });
        }

        function isPointInShape(shape, x, y) {
            if (shape.type === 'square') {
                return x >= shape.x && x <= shape.x + shape.size && y >= shape.y && y <= shape.y + shape.size;
            } else if (shape.type === 'circle') {
                const dx = x - shape.x;
                const dy = y - shape.y;
                return (dx * dx + dy * dy <= shape.radius * shape.radius);
            } else if (shape.type === 'star') {
                const distance = Math.sqrt((x - shape.x) ** 2 + (y - shape.y) ** 2);
                return distance <= shape.outerRadius; // Colisión simple
            }
            return false;
        }

        function moveFreeDraw(x, y) {
            shapes.forEach(shape => {
                if (shape.type === 'free') {
                    shape.points.forEach(point => {
                        point.x += x - lastX;
                        point.y += y - lastY;
                    });
                }
            });
        }