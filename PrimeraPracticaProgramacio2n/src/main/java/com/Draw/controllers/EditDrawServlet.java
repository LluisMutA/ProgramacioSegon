package com.Draw.controllers;

import com.Draw.dao.DrawDAO;
import com.Draw.dao.DrawDAOInMemory;
import com.Draw.model.Draw;
import com.Draw.model.Figure;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

@WebServlet("/edit-draw")
public class EditDrawServlet extends HttpServlet {

    DrawDAO drawDAO = new DrawDAOInMemory();
    Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String drawIdParam = req.getParameter("drawId");
        if (drawIdParam == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "No se proporcionó el ID del dibujo.");
            return;
        }

        int drawId = Integer.parseInt(drawIdParam);
        Draw draw = drawDAO.findById(drawId);

        if (draw == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "El dibujo no existe.");
            return;
        }

        req.setAttribute("draw", draw);
        req.setAttribute("figuresJSON", gson.toJson(draw.getFig()));
        req.getRequestDispatcher("/edit-draw.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String drawIdParam = req.getParameter("drawId");
//        String drawTitle = req.getParameter("drawTitle");
//        String backgroundColor = req.getParameter("backgroundColor");
//        String figuresJSON = req.getParameter("saveDraw");

//        System.out.println("drawId: " + req.getParameter("drawId"));
//        System.out.println("drawTitle: " + req.getParameter("drawTitle"));
//        System.out.println("backgroundColor: " + req.getParameter("backgroundColor"));
//        System.out.println("saveDraw: " + req.getParameter("saveDraw"));

//        if (drawIdParam == null || drawTitle == null || backgroundColor == null || figuresJSON == null) {
//            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Faltan parámetros requeridos.");
//            return;
//        }

//        int drawId = Integer.parseInt(drawIdParam);

//        Type figureListType = new TypeToken<List<Figure>>() {
//        }.getType();
//        List<Figure> updatedFigures = gson.fromJson(figuresJSON, figureListType);

//        try {
//            drawDAO.updateDraw(drawId, drawTitle, updatedFigures, backgroundColor, new Date());
//            resp.sendRedirect("/draw-gallery"); // Redirigir a la galería después de guardar
//        } catch (IllegalArgumentException e) {
//            resp.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
//        }
//    }


        DrawDAO drawDAO = new DrawDAOInMemory();
        String drawId = req.getParameter("drawId");
        Draw draw = drawDAO.findById(Integer.parseInt(drawId));
        String drawTitle = req.getParameter("drawTitle");
        String backgroundColor = req.getParameter("backgroundColor");

        req.setAttribute("drawId", draw.getDrawId());
        req.setAttribute("drawTitle", draw.getDrawTitle());
        req.setAttribute("backgroundColor", draw.getBackgroundColor());
        req.setAttribute("figuresDraw", gson.toJson(draw.getFig()));
        req.setAttribute("listaFiguras", draw.getFig());


        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/edit-draw.jsp");
        requestDispatcher.forward(req, resp);
    }
}

