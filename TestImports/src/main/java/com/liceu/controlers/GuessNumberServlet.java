package com.liceu.controlers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/guess")
public class GuessNumberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Integer secret = (int) (Math.random()*20);
        Cookie ck = new Cookie("secret", ""+secret);
        resp.addCookie(ck);
        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/GuessNumber.jsp");
        requestDispatcher.forward(req, resp);
    }

        @Override
        protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Integer num = Integer.parseInt(req.getParameter("num"));
            Integer secret = 0;
            for(Cookie c : req.getCookies()){
                if(c.getName().equals("secret")){
                    secret = Integer.parseInt(c.getValue());
                    break;
                }
            }
            String message = "";
            if(message.matches("^\\d+$")){
                message = "No has introduit numero";
            }
            if(num.equals(secret)){
                message = "Has acertat!";
            } else if(num < secret){
                message = "Num mes gran";
            }else{
                message = "Num mes petit";
            }
            req.setAttribute("message", message);


            RequestDispatcher requestDispatcher =
                    req.getRequestDispatcher("/WEB-INF/jsp/GuessNumber.jsp");
            requestDispatcher.forward(req, resp);

    }
}
