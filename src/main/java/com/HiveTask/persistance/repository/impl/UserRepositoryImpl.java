package com.HiveTask.persistance.repository.impl;

import com.HiveTask.domain.entity.User;
import com.HiveTask.domain.services.UserService;
import com.HiveTask.persistance.dao.UserDao;
import com.HiveTask.persistance.repository.UserRepository;


public class UserRepositoryImpl implements UserRepository {

    private final UserDao userDao;

    public UserRepositoryImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void userRegister(User user) {
        userDao.userRegister(user);
    }

    @Override
    public void userLoginByEmail(String email, String password) {
        userDao.userLoginByEmail(email, password);
    }

    @Override
    public void userLoginByName(String userName, String password) {
        userDao.userLoginByName(userName, password);
    }
}
