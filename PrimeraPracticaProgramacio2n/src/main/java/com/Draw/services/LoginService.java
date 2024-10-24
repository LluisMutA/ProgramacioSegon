package com.Draw.services;

import com.Draw.dao.UserDAO;
import com.Draw.dao.UserDAOInMemory;
import com.Draw.model.User;

public class LoginService {
    UserDAO userDAO = new UserDAOInMemory();

    public User checkUser(String username, String password, int id){
        User user = userDAO.findByUsernameAndPassword(username, password, id);
        return user;
    }

    public User createUser(String username, String password, String passwordCheck, String name, int id) {
        User user = new User(username, password, name, id);
        if (!password.equals(passwordCheck)) {
            throw new RuntimeException("Passwords no coincideixen");
        }
        if (password.length() < 5)
            throw new RuntimeException("Password too short");
        userDAO.newUser(user);
        if(password.equals(passwordCheck)){
            UserDAOInMemory register = new UserDAOInMemory();
            register.addNewUser(username, password, name, id);
            System.out.println("Account created"); // TODO: Message
            System.out.println("Username: "+ username + " Pass: " + password);
        }else System.out.println("Paswords doesnt match!");
        return user;
        /*

        for(User u : userDAO{
            String usr = u.getUsername();
            System.out.println("REGISTER SERVLET: " + u.getUsername() +"   " +u.getPassword());
            if(username.equals(usr)){
                System.out.println("User repetido");
                break;
            }else
            if(password.equals(passwordCheck)){
                UserDAOInMemory register = new UserDAOInMemory();
                register.addNewUser(username, password);
                System.out.println("Account created"); // TODO: Message
                System.out.println("Username: "+ username + " Pass: " + password);
            }else System.out.println("Paswords doesnt match!");
        }*/
    }
}
