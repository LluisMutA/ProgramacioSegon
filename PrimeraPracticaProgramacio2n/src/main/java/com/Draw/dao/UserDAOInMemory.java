package com.Draw.dao;

import com.Draw.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAOInMemory  implements  UserDAO{
    static List<User> users = new ArrayList<>();

    static {
        users.add(new User("bill", "1234", "Bill", 1));
        users.add(new User("libb", "4321", "Miguel", 2));
        users.add(new User("jhon", "dddd","Maria",3));
        users.add(new User("bill2", "1234321","Alberto",4));
    }

    @Override
    public User newUserCredentials(String username, String password, String name) {
        User user = new User(username, password, name);
        newUser(user);
        return user;
    }

    @Override
    public User findByUsername(String username){
        for (User u: users){
            if(u.getUsername().equals(username)){
                System.out.println(users);
                return u;
            }
        }
        return null;
    }

    @Override
    public User checkUsernameAndPassword(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void newUser(User user) {
        user.setId(users.size()+1);
        users.add(user);
        for(User s: users){
            System.out.println("Username" + s.getUsername() + "Password" + s.getPassword() + "Name" + s.getName() + "ID" + s.getId());
        }
    }
}