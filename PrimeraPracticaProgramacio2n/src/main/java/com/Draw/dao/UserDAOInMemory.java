package com.Draw.dao;

import com.Draw.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAOInMemory  implements  UserDAO{
    static List<User> users = new ArrayList<>();

    static {
        users.add(new User("bill", "1234", 1));
        users.add(new User("libb", "4321",2));
        users.add(new User("jhon", "dddd",3));
        users.add(new User("bill2", "1234321",4));
    }

    @Override
    public User findByUsernameAndPassword(String username, String password, int id){
        for (User u: users){
            if(u.getUsername().equals(username)&& u.getPassword().equals(password)){
                System.out.println(users);
                return u;
            }
        }
        return null;
    }

    @Override
    public void newUser(User user) {
        for(User u: users) {
            if (u.getUsername().equals(user.getUsername())) {
                // Has trobat duplicat
                throw new RuntimeException("Usuari duplicat");
            }
        }
        users.add(user);
    }


    public  void addNewUser(String username, String password){
        int id = users.size();
        id++;
        users.add(new User(username, password, id));
        for (User u : users){
            System.out.println("User: " + u.getUsername() +" Pass: "+ u.getPassword()+ " ID: "+ u.getId());
        }
    }
}