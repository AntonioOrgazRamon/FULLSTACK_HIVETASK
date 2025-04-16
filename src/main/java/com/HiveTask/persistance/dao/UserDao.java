package com.HiveTask.persistance.dao;

import com.HiveTask.domain.entity.User;

public interface UserDao {

    void userRegister(User user);
    void userLoginByEmail(String email);
    void userLoginByName(String name);


}
