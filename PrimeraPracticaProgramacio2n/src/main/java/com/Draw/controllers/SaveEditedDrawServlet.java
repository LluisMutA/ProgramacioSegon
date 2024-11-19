package com.Draw.controllers;

import com.Draw.dao.DrawDAO;
import com.Draw.dao.DrawDAOInMemory;
import com.Draw.model.Draw;
import com.Draw.model.Figure;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

@WebServlet("/save-edited-draw")
public class SaveEditedDrawServlet extends HttpServlet {
    Gson gson = new Gson();
    DrawDAO drawDAO = new DrawDAOInMemory();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!Utils.userOK(req)) {
            resp.sendRedirect("/login");
            return;
        }

        String body = req.getReader().lines().reduce("", String::concat);
        EditRequest editRequest = gson.fromJson(body, EditRequest.class);

        Draw draw = drawDAO.findByName(editRequest.drawTitle);
        if (draw == null || !draw.getUser().getUsername().equals(req.getSession().getAttribute("user"))) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN, "No estás autorizado para editar este dibujo.");
            return;
        }

        Type figureType = new TypeToken<List<Figure>>() {}.getType();
        List<Figure> updatedFigures = gson.fromJson(editRequest.saveDraw, figureType);

        drawDAO.updateDraw(
                draw.getDrawId(),
                editRequest.drawTitle,
                updatedFigures,
                editRequest.backgroundColor,
                new Date(System.currentTimeMillis())
        );

        resp.setStatus(HttpServletResponse.SC_OK);
    }

    private static class EditRequest {
        String drawTitle;
        String backgroundColor;
        String saveDraw;
    }
}

