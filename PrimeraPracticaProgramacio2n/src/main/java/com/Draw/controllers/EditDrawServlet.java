package com.Draw.controllers;

import com.Draw.dao.DrawDAO;
import com.Draw.dao.DrawDAOInMemory;
import com.Draw.model.Draw;
import com.Draw.model.Figure;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit-draw")
public class EditDrawServlet extends HttpServlet {
    Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DrawDAO drawDAO = new DrawDAOInMemory();
        String drawId = req.getParameter("drawId");
        Draw draw = drawDAO.findById(Integer.parseInt(drawId));
//       String drawTitle = req.getParameter("drawTitle");
//       String backgroundColor = req.getParameter("backgroundColor");

        req.setAttribute("drawId", draw.getDrawId());
        req.setAttribute("drawTitle", draw.getDrawTitle());
        req.setAttribute("backgroundColor", draw.getBackgroundColor());
        req.setAttribute("figures", gson.toJson(draw.getFig()));

        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/edit-draw.jsp");
        requestDispatcher.forward(req, resp);
    }
}
