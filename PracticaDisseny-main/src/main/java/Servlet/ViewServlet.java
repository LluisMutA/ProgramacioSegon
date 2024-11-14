package Servlet;

import db.DrawingDAOInMemory;
import model.Drawing;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/newview")
public class ViewServlet extends HttpServlet {

        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            // Aquí deberías recuperar los datos (elementos, dibujos, etc.) de la sesión
            // Pasa los datos al JSP

            DrawingDAOInMemory db = new DrawingDAOInMemory();
            List<Drawing> drawings = new ArrayList<>();

            drawings = db.getAllDrawings();


            req.setAttribute("drawings", drawings);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/newview.jsp");
            dispatcher.forward(req, resp);
        }

    }
