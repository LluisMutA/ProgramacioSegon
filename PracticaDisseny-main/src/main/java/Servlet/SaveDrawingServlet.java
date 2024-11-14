package Servlet;

import Service.DrawingService;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import db.DrawingDAO;
import db.DrawingDAOInMemory;
import model.Drawing;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/saveDrawing")
public class SaveDrawingServlet extends HttpServlet {
    DrawingService db = new DrawingService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String dataJson = request.getParameter("drawingData");

        if (dataJson != null && !dataJson.isEmpty()) {

            Gson gson = new Gson();
            try {
                Drawing drawing = gson.fromJson(dataJson, Drawing.class);
                db.addDraw(drawing);
                request.setAttribute("drawings", drawing);

                response.sendRedirect("dashboard");
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Error al procesar el JSON.");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El dibujo no se recibió correctamente.");
        }
    }
}


