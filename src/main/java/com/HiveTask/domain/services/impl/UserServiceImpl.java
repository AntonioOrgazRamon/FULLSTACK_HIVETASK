package com.HiveTask.domain.services.impl;

import com.HiveTask.domain.entity.User;
import com.HiveTask.domain.services.UserService;
import com.HiveTask.persistance.repository.UserRepository;

public class UserServiceImpl implements UserService  {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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
