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

    }

    @Override
    public void userLoginByEmail(String email) {

    }

    @Override
    public void userLoginByName(String name) {

    }
}
