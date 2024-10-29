package com.Draw.controlers;

import com.Draw.dao.UserDAOInMemory;
import com.Draw.model.User;
import com.Draw.services.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {

    LoginService loginService = new LoginService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/Register.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String passwordCheck = req.getParameter("passwordCheck");

        try {
            loginService.createUser(username, password, passwordCheck, name);
        } catch(Exception e) {
            req.setAttribute("message", e.getMessage());
        }

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/Register.jsp");
        requestDispatcher.forward(req, resp);
    }

}
