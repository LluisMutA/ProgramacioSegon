package com.liceu.controlers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/jstl")
public class jstlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("name", "Cacahuete");
     //   rep.SetAtribute(message)

        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/first.jsp");
        requestDispatcher.forward(req, resp);
    }
}
