package Servlet;

import Service.RegistrationService;
import errorhandler.ErrorCodes;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    RegistrationService registrationService = new RegistrationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegistrationService checkService = new RegistrationService();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");

        // Validar y guardar el nuevo usuario
        ErrorCodes isRegistered = registrationService.registerUser(username, name, password);
        if(isRegistered.equals(ErrorCodes.OK))
        {
            resp.sendRedirect("/login");
        }
        else {
            req.setAttribute("message", "REGISTER STATUS: " + isRegistered.getStatus());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
            requestDispatcher.forward(req, resp);
        }


    }
}
