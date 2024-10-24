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
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        int id = 0;

        String passwordCheck = req.getParameter("passwordCheck");

        String message = ""; //TODO: asignar ip (.lenght+1)
//        try {
        loginService.createUser(username, password, passwordCheck, name, id);
//        } catch (Exception e) {
//            System.out.println("algo no ha ido bien amic"); // Cambiar a message en tenir temps
//        }
        //createUserLogic(password, passwordCheck, username);

        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/Register.jsp");
        requestDispatcher.forward(req, resp);
    }
}
