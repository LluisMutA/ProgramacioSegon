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

@WebServlet("/test")
public class TestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Drawing> list = new ArrayList<>();

        list.add(new Drawing(1,"testname",1,"testuser"));
        list.add(new Drawing(2,"testname2",2,"testuser2"));

        Drawing drawing = new Drawing(3,"testname2", 3, "testuser3");
        req.setAttribute("drawings", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/newview.jsp");
        dispatcher.forward(req, resp);
    }
}


