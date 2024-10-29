package com.Draw.dao;

import com.Draw.model.User;

public interface UserDAO {
    User findByUsername(String username);

    void newUser(User user);
}
