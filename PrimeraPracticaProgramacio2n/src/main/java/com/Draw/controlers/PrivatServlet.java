package com.Draw.controlers;

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
        //Primer miram que dins la sessio de l'user tenim l'atribut "user" amb un valor
//        HttpSession session = req.getSession();
//        String user = (String) session.getAttribute("user");
//        if(user == null){
//            //user no autoritzat
//            resp.sendRedirect("/login");
//            return;
//        }
        if(!Utils.userOK(req)){
            resp.sendRedirect("/login");
            return;
        }

        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/private.jsp");
        requestDispatcher.forward(req, resp);
    }
}
