package com.Draw.controlers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String passwordCheck = req.getParameter("passwordCheck");
        String message = ""; //TODO: asignar ip (.lenght+1)
        if(password.equals(passwordCheck)){
            message+= "Account created";
        }

        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/Register.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setAttribute("message");
        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/Register.jsp");
        requestDispatcher.forward(req, resp);
    }
}
