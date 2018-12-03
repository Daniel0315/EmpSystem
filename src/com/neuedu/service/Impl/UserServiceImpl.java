package com.neuedu.service.Impl;

import com.neuedu.dao.UserDao;
import com.neuedu.dao.impl.UserDaoImpl;
import com.neuedu.entity.User;
import com.neuedu.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User getUserByUsername(String username) {
        UserDao userDao=new UserDaoImpl();
        return userDao.getUserByUsername(username);
    }
}
