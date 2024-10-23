package com.liceu.dao;

import com.liceu.model.User;

public interface UserDAO {
    User findByUsernameAndPassword(String username, String password);
}
