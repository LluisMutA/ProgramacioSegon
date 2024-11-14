package com.esliceu.demospring.services;

import com.esliceu.demospring.model.Person;
import com.esliceu.demospring.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    UserDAO userDAO;

    public List<Person> allPersons() {
        return userDAO.findAll();
    }

    public void newPerson(int year, String name) {
        Person p = new Person();
        p.setName(name);
        p.setYear(year);
        userDAO.save(p);
    }
}