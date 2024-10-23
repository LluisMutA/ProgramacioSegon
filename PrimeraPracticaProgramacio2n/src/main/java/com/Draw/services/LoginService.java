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
}
