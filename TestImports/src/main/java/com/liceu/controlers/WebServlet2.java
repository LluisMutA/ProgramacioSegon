package com.liceu.controlers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/web2")


public class WebServlet2 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("temp", 27);
        req.setAttribute("money", 1000001);

        Map<String, Integer> classes = new HashMap<>();
        classes.put("dilluns", 5);
        classes.put("dimarts", 3);
        classes.put("dimecres", 4);
        classes.put("dijous", 1);
        classes.put("divendres", 2);
        req.setAttribute("cls", classes);

        Person p = new Person("Pep", 2001);
        req.setAttribute("pep", p);


        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/second.jsp");
        requestDispatcher.forward(req, resp);
    }


}
