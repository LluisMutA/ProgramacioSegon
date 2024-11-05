package com.Draw.controllers;

import com.Draw.dao.UserDAO;
import com.Draw.dao.UserDAOInMemory;
import com.Draw.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Utils {
    private static UserDAO userDAO = new UserDAOInMemory();

    public static boolean userOK(HttpServletRequest req) {
        HttpSession session = req.getSession(false); // No crear una nueva sesión si no existe
        if (session == null) {
            return false; // No hay sesión activa
        }

        String user = (String) session.getAttribute("user"); // Obtén el username
        req.setAttribute("user", user);
        return user != null; // TODO: quisas es user solo Devuelve verdadero si el usuario está autenticado
    }
}
