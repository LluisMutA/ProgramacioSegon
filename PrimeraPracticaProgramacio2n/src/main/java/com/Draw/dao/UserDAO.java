package com.Draw.dao;

import com.Draw.model.User;

public interface UserDAO {
    User findByUsername(String username);

    User chekUsernameAndPassword(String username, String password);

    void newUser(User user);
}
