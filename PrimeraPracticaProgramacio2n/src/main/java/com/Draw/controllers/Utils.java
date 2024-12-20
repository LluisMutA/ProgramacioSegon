package com.Draw.controllers;

import com.Draw.dao.UserDAO;
import com.Draw.dao.UserDAOInMemory;
import com.Draw.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Utils {
    private static UserDAO userDAO = new UserDAOInMemory();

    public static boolean userOK(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null) {
            return false;
        }

        String username = (String) session.getAttribute("user"); // Obtén el username
        req.setAttribute("username", username);
        return username != null; // TODO: Fallo al autentificar els dibujos, antes es comprovaba el user, no usrname, per aixo no es podia borrar
    }
}
