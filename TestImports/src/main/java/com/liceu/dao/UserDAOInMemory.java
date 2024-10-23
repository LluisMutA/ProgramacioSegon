package com.liceu.dao;

import com.liceu.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAOInMemory  implements  UserDAO{
    static List<User> users = new ArrayList<>();

    static {
        System.out.println("-------------------------------------------------------------");
        users.add(new User("bill", "1234"));
        users.add(new User("libb", "4321"));
        users.add(new User("jhon", "dddd"));
        users.add(new User("bill2", "1234321"));
    }

    @Override
    public User findByUsernameAndPassword(String username, String password){
        for (User u: users){
            if(u.getUsername().equals(username)&& u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    };

}