package com.Draw.controlers;

import com.Draw.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Utils {
    public static boolean userOK(HttpServletRequest req) {
        HttpSession session = req.getSession(false); // No crear una nueva sesión si no existe
        if (session == null) {
            return false; // No hay sesión activa
        }

        User user = (User) session.getAttribute("user"); // Obtén el objeto User
        req.setAttribute("username", user.getUsername());
        return user != null; // Devuelve verdadero si el usuario está autenticado
    }
}


//public class Utils {
//    public static boolean userOK(HttpServletRequest req){
//        HttpSession session = req.getSession();
//        String user = (String) session.getAttribute("user");
//        if(user == null){
//            return false;
//        }
//        req.setAttribute("username", user);
//        return true;
//    }
//}
