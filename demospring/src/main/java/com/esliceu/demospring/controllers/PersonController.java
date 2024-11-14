package com.esliceu.demospring.controllers;

import com.esliceu.demospring.model.Person;
import com.esliceu.demospring.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PersonController {
    @Autowired
    PersonService personService;
    @GetMapping("/persons")
    public String listPersons(Model model){
        List<Person> persons = personService.allPersons();
        model.addAttribute("persons", persons);
        return "persons";
    }

    @PostMapping("/persons")
    public String newPerson(@RequestParam String name, @RequestParam int year){
        personService.newPerson(year, name);
        return "persons";
    }
}
