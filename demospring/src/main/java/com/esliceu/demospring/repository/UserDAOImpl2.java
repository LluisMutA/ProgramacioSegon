package com.esliceu.demospring.repository;

import com.esliceu.demospring.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl2 implements UserDAO{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person",
                new BeanPropertyRowMapper<>(Person.class));
    }

    @Override
    public void save(Person p) {
        jdbcTemplate.update("insert into person (name, year) values (?, ?)",
                p.getName(), p.getYear());
    }
}