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
import java.lang.reflect.Type;

@WebServlet("/view-canvas")
public class ViewCanvasServlet extends HttpServlet {
    Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DrawDAO drawDAO = new DrawDAOInMemory();
        String name = req.getParameter("name");
        Draw draw = drawDAO.findByName(name);

        req.setAttribute("drawId", draw.getDrawId());
        req.setAttribute("drawTitle", draw.getDrawTitle());
        req.setAttribute("author", draw.getUser().getName());
        req.setAttribute("backgroundColor", draw.getBackgroundColor());
        req.setAttribute("figures", gson.toJson(draw.getFig()));

        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/view-canvas.jsp");
        requestDispatcher.forward(req, resp);
    }
}
