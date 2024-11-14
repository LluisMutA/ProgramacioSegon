package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/deleteElement")
public class DeleteElementServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.sendRedirect("login");
            return;
        }
        int index = Integer.parseInt(req.getParameter("index"));

        List<String> elementos = (List<String>) session.getAttribute("elementos");

        if (elementos != null && index >= 0 && index < elementos.size()) {
            elementos.remove(index);
        }

        // Redirigir de vuelta al dashboard
        resp.sendRedirect("dashboard");
    }
}
