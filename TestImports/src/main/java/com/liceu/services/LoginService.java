package com.liceu.services;

import com.liceu.dao.UserDAO;
import com.liceu.dao.UserDAOInMemory;
import com.liceu.model.User;

public class LoginService {
    UserDAO userDAO = new UserDAOInMemory();

    public User checkUser(String username, String password){
        User user = userDAO.findByUsernameAndPassword(username, password);
        return user;
    }
}
