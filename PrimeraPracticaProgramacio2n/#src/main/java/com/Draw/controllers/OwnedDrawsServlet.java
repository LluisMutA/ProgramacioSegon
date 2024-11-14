package com.Draw.controllers;

import com.Draw.dao.DrawDAO;
import com.Draw.dao.DrawDAOInMemory;
import com.Draw.model.Draw;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/owned-gallery")
public class OwnedDrawsServlet extends HttpServlet{
    DrawDAO drawDAO = new DrawDAOInMemory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Draw> allDraws = drawDAO.findAllDraws();
        String username = (String) req.getSession().getAttribute("user");
        req.setAttribute("username", username);
        req.setAttribute("draws", allDraws);

        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/owned-draws.jsp");
        requestDispatcher.forward(req, resp);
    }
}
