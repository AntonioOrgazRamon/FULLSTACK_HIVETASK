package com.HiveTask.domain.services;

import com.HiveTask.domain.entity.User;

public interface UserService {

  void userRegister(User user);
  void userLoginByEmail(String email);
  void userLoginByName(String name);



}
