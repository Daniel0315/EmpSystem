package com.neuedu.dao;

import com.neuedu.entity.User;

public interface UserDao {
    User getUserByUsername(String username);
}
