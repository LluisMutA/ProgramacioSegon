package com.liceu.controlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Utils {
    public static boolean userOK(HttpServletRequest req){
        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("user");
        if(user == null){

            return false;
        }
        req.setAttribute("username", user);
        return true;
    }
}
