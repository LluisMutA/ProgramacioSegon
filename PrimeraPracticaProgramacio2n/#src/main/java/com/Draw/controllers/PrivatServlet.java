package com.Draw.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/private")
public class PrivatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       if (!Utils.userOK(req)) {
           resp.sendRedirect("/login");
           return;
       }

//TODO: PONERBIEN DESCOMENTAR LAS 3 LINEAS DE ARRIBA AL ACABAR EL CANVAS
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/private.jsp");
        requestDispatcher.forward(req, resp);
    }
}


