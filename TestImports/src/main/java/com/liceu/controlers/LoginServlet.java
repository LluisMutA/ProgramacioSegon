package com.liceu.controlers;

import com.liceu.model.User;
import com.liceu.services.LoginService;

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
        User user = loginService.checkUser(username, password);
        if(user != null){
            //Usuari i pass correcte
            HttpSession session = req.getSession();
            session.setAttribute("user", username);
            //Crea un objecte dins del  agatzem de sessions
            // del servidor. Aquest és el nom de l'usuari autenticat
            // El servidor crea o empra la COOKIE i l'envia al client. Dins
            // hi ha un identificador que identifica la sessio correcte

            //Redireccionar a l'usuari cap una pagina privada
            resp.sendRedirect("/private");
            return;
        }else{
            //Retornar codi 401: Not Authorized
            // Tornar un codi 200 normal amb una variable per indicar que no es correcte el login
            // aixi l'usuari no veu la pagina 401 estandars, sino unoa 200 amb infromacio
            req.setAttribute("message", "Usuari i/o Password incorrectes");
        }
        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/LogIn.jsp");
        requestDispatcher.forward(req, resp);
    }
}
