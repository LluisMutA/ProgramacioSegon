package com.Draw.dao;

import com.Draw.model.User;

public interface UserDAO {
    User findByUsernameAndPassword(String username, String password, int id);
}
