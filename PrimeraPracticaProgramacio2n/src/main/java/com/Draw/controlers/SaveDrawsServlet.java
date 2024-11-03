package com.Draw.controlers;


import com.Draw.dao.DrawDAO;
import com.Draw.dao.DrawDAOInMemory;
import com.Draw.dao.UserDAO;
import com.Draw.dao.UserDAOInMemory;
import com.Draw.model.Draw;
import com.Draw.model.Figure;
import com.Draw.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@WebServlet("/save-draw")
public class SaveDrawsServlet extends HttpServlet {
Gson gson = new Gson();
DrawDAO drawDAO = new DrawDAOInMemory();
UserDAO userDAO = new UserDAOInMemory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/private");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String drawTitle = req.getParameter("drawTitle");
        String saveDraw = req.getParameter("saveDraw");
        Date date = new Date(System.currentTimeMillis());
        User user = userDAO.findByUsername((String) req.getSession().getAttribute("user"));

        Type figureType = new TypeToken<List<Figure>>() {}.getType();

        List<Figure> figure = gson.fromJson(saveDraw, figureType);
        drawDAO.addDraw(drawTitle, figure, user, date, date);

        System.out.println(drawDAO.findAllDraws());
        resp.sendRedirect("/draw-galery");
    }
}

//form hidden amb id per enviar el string de JSON (element.value(string
// GSON, maven)