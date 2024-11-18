package com.Draw.controllers;

import com.Draw.dao.DrawDAO;
import com.Draw.dao.DrawDAOInMemory;
import com.Draw.model.Draw;
import com.Draw.services.DrawService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-draw")
public class DeleteDrawServlet extends HttpServlet {
    DrawService drawService = new DrawService();
    DrawDAO drawDAO = new DrawDAOInMemory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!Utils.userOK(req)) {
            resp.sendRedirect("/login");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = (String) req.getParameter("user");
        String drawId =  req.getParameter("draw");
        drawService.deleteByDrawId(user, Integer.parseInt(drawId));

        resp.sendRedirect("/draw-gallery");
    }
}
