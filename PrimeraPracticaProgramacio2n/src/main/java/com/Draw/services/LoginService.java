package com.Draw.services;

import com.Draw.dao.UserDAO;
import com.Draw.dao.UserDAOInMemory;
import com.Draw.model.User;

public class LoginService {
    UserDAO userDAO = new UserDAOInMemory();

    public User checkUser(String username){
        return userDAO.findByUsername(username);
    }

    public User login(String username, String password) { // COMPROVAR
        User user = userDAO.chekUsernameAndPassword(username, password);
        if (user == null) {
            throw new RuntimeException("Nombre de usuario o contraseña incorrectos");
        }
        return user;
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
}
