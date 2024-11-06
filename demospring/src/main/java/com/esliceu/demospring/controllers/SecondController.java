package com.esliceu.demospring.controllers;

import com.esliceu.demospring.model.Person;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SecondController {

   //@GetMapping("/suma")
   //public String suma(@RequestParam int n1, @RequestParam int n2, Model model){
   //   int res = n1 + n2;
   //   model.addAttribute("result", res);
   //    return "suma";
   //}

   //@GetMapping("/person")
   //public String getPerson(){
   //    return "personform";
   //}
   //@PostMapping("/person")
   //public String postPerson(@RequestBody Person person){

   //    return "personform";
   //}


    @GetMapping("/session")
    public String exSession(HttpSession session, Model m){
        Object o = session.getAttribute("visites");
        if (o == null){
            session.setAttribute("visites",0);
            o =  (Integer)0;
        }
        Integer visites = (Integer) o;
        visites++;
        session.setAttribute("visites", visites);

        m.addAttribute("visites",visites);
        return "contador";
    }

}

//@GetMapping("/suma/{n1}/{n2}")
// @PathVariable int n1, int n2(EXEMPLE: HTTP:..../suma/3/10)
