package com.Draw.services;

import com.Draw.dao.UserDAO;
import com.Draw.dao.UserDAOInMemory;
import com.Draw.model.User;

public class LoginService {
    UserDAO userDAO = new UserDAOInMemory();

    public User checkUser(String username, String password, int id){
        return userDAO.findByUsername(username);
    }

    public User createUser(String username, String password, String passwordCheck, String name) {
        if (!password.equals(passwordCheck)) {
            throw new RuntimeException("Las contraseñas no coinciden");
        }
        if (password.length() < 5) {
            throw new RuntimeException("La contraseña es demasiado corta");
        }
        if (userDAO.findByUsername(username) != null) {
            throw new RuntimeException("El nombre de usuario ya está en uso");
        }

        User user = new User(username, password, name);
        userDAO.newUser(user);

        System.out.println("Cuenta creada");
        System.out.println("Username: " + username + " Pass: " + password);
        return user;
    }

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
