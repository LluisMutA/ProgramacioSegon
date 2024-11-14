package Servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import Service.LoginService;
import model.*;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    LoginService loginService = new LoginService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        requestDispatcher.forward(req, resp);
        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = loginService.checkUser(username, password);
        if(user != null){
            //Usuari i pass correcte
            HttpSession session = req.getSession();
            session.setAttribute("user", username);
            //TODO Llevar al dashboard de usuarios registrados
            resp.sendRedirect("/dashboard");
        }else{
            req.setAttribute("message", "Usuari i/o Password incorrectes");
            RequestDispatcher requestDispatcher =
                    req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            requestDispatcher.forward(req, resp);
        }

    }

}

