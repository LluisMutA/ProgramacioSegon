package com.Draw.dao;

import com.Draw.model.User;

public interface UserDAO {
    User newUserCredentials(String username, String password, String name);

    User findByUsername(String username);

    User checkUsernameAndPassword(String username, String password);

    void newUser(User user);
}
