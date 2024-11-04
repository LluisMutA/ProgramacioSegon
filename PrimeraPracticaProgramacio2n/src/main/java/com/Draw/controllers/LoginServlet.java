package com.Draw.controllers;

import com.Draw.model.User;
import com.Draw.services.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    LoginService loginService = new LoginService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/LogIn.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            User user = loginService.login(username, password);

            HttpSession session = req.getSession();
            session.setAttribute("user", user.getUsername());

            resp.sendRedirect("/private");
        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/LogIn.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
