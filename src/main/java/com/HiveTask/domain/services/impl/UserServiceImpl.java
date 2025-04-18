package com.HiveTask.domain.services.impl;

import com.HiveTask.domain.entity.User;
import com.HiveTask.domain.services.UserService;
import com.HiveTask.persistance.repository.UserRepository;
import org.springframework.stereotype.Service;


public class UserServiceImpl implements UserService  {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void userRegister(User user) {
        userRepository.userRegister(user);
    }

    @Override
    public void userLoginByEmail(String email, String password) {
        userRepository.userLoginByEmail(email, password);

    }

    @Override
    public void userLoginByName(String userName, String password) {
        userRepository.userLoginByName(userName, password);

    }
}
