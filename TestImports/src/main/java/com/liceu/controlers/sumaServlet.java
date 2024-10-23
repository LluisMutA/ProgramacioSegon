package com.liceu.controlers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/suma")
public class sumaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/suma.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer na = Integer.parseInt(req.getParameter("na"));
        Integer nb = Integer.parseInt(req.getParameter("nb"));
        String operacio = req.getParameter("operacio");
        Integer res = 0;
        if (operacio.equals("suma")){
            res = na + nb;
        }
        if (operacio.equals("resta")){
            res = na - nb;
        }
        if (operacio.equals("mult")){
            res = na * nb;
        }
        if (operacio.equals("div")){
            res = na / nb;
        }

        req.setAttribute("resultat", res);

        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/suma.jsp");
        requestDispatcher.forward(req, resp);
    }
}
