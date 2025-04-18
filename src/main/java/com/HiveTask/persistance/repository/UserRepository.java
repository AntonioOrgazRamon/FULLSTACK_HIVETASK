package com.HiveTask.persistance.repository;

import com.HiveTask.domain.entity.User;

public interface UserRepository {

    void userRegister(User user);
    void userLoginByEmail(String email, String password);
    void userLoginByName(String name, String password);



}
