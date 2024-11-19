package com.Draw.controllers;

import com.Draw.dao.DrawDAO;
import com.Draw.dao.DrawDAOInMemory;
import com.Draw.model.Draw;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit-canvas")
public class EditServlet extends HttpServlet {
    Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!Utils.userOK(req)) {
            resp.sendRedirect("/login");
            return;
        }

        DrawDAO drawDAO = new DrawDAOInMemory();
        String name = req.getParameter("name");
        Draw draw = drawDAO.findByName(name);

        if (draw == null || !draw.getUser().getUsername().equals(req.getSession().getAttribute("user"))) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN, "No estás autorizado para editar este dibujo.");
            return;
        }

        req.setAttribute("drawTitle", draw.getDrawTitle());
        req.setAttribute("backgroundColor", draw.getBackgroundColor());
        req.setAttribute("figures", gson.toJson(draw.getFig()));

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/edit-canvas.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener el parámetro drawId del formulario
        String drawIdStr = req.getParameter("drawId");

        // Verificar si drawId es válido
        if (drawIdStr != null && !drawIdStr.isEmpty()) {
            try {
                // Intentar convertir drawId a un número entero
                int drawId = Integer.parseInt(drawIdStr);

                // Resto de la lógica, como obtener el dibujo y actualizarlo
                DrawDAO drawDAO = new DrawDAOInMemory();
                Draw draw = drawDAO.findById(drawId);

                if (draw == null) {
                    resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Dibujo no encontrado.");
                    return;
                }

                // Aquí actualizarías el dibujo, por ejemplo con las figuras modificadas
                String updatedFigures = req.getParameter("figures");
                // Lógica para actualizar las figuras en el dibujo

                // Redirigir a la página de galería o donde sea necesario
                resp.sendRedirect("/draw-gallery");
            } catch (NumberFormatException e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "El ID del dibujo no es válido.");
                return;
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Falta el ID del dibujo.");
            return;
        }
    }

}
