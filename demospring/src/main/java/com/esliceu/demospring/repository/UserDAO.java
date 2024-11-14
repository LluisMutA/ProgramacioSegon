package com.esliceu.demospring.repository;

import com.esliceu.demospring.model.Person;

import java.util.List;

public interface UserDAO {
    List<Person> findAll();

    void save(Person p);
}
