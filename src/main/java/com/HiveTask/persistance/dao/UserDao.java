package com.HiveTask.persistance.dao;

import com.HiveTask.domain.entity.User;

public interface UserDao {

    void userRegister(User user);
    void userLoginByEmail(String email, String password);
    void userLoginByName(String name, String password);


}
