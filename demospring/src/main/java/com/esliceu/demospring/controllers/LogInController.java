package com.esliceu.demospring.controllers;


import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LogInController {

        @GetMapping("/login")
        public String getLogin() {
            return "login";
        }

        @PostMapping("/login")
        public String login(@RequestParam String username, @RequestParam String password, HttpSession session){
        if(username.equals("a") && password.equals("a")){
            session.setAttribute("user", username);
            return "login";
        }
        return "login";
    }
        @GetMapping("/private")
        public String privatePage(HttpSession session, Model m, @RequestParam String user){
            m.addAttribute("user", user);
            return  "private"; //no existeix encara
        }
    }

