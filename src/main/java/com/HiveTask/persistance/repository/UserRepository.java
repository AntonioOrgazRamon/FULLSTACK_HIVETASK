package com.HiveTask.persistance.repository;

import com.HiveTask.domain.entity.User;

public interface UserRepository {

    void userRegister(User user);
    void userLoginByEmail(String email);
    void userLoginByName(String name);



}
