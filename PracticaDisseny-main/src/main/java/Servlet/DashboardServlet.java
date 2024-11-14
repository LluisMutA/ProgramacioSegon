package Servlet;

import Service.DrawingService;
import db.DrawingDAO;
import db.DrawingDAOInMemory;
import model.Drawing;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    DrawingService drawingService = new DrawingService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Aquí deberías recuperar los datos (elementos, dibujos, etc.) de la sesión
        // Pasa los datos al JSP
        List<Drawing> list = drawingService.getAllDrawings();
        drawingService.printDrawings();

        System.out.println("//// - DATABASE TEST -////");
        for (Drawing d : list){

            System.out.println("ID: " + d.getId() + " NAME: " +d.getName()
                    + " ID_USER: " + d.getId_user() + " USER: " +d.getUser());
        }

        req.setAttribute("drawings", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/dashboard.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        // TODO mirar si usuari esta autoritzat

        // Has de rebre un string on ho ha el dibuix en json
/*
        List<Drawing> drawings = new ArrayList<>();

        drawings = drawingService.getAllDrawings();

        if (drawings == null) {
            drawings = new ArrayList<>();

        }
        // Imprime cada dibujo en la consola
        if (drawings != null){
        }

        String json = req.getParameter("dataJson");
        System.out.println("JSON :"+json);

        // Fer un parse del json i posar.ho dins objectes java
        // cridar a dao i guardar
        req.setAttribute("drawings", json);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/dashboard.jsp");
        dispatcher.forward(req, resp);
*/

    }
}


