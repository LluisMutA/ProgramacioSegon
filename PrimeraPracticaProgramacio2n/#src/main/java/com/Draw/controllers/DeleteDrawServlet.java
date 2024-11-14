package com.Draw.controllers;

import com.Draw.dao.DrawDAO;
import com.Draw.dao.DrawDAOInMemory;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!Utils.userOK(req)) {
            resp.sendRedirect("/login");
            return;
        }
        String user = (String) req.getAttribute("user");
        String drawingName = req.getParameter("name");
        drawService.deleteByName(user, drawingName);


        resp.sendRedirect("/draw-gallery");
    }
}
