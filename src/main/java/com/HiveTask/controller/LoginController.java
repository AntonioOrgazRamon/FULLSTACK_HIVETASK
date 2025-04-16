package com.HiveTask.controller;

import com.HiveTask.common.ioc.UserIoc;
import com.HiveTask.domain.entity.User;
import com.HiveTask.domain.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")


public class LoginController {

    private UserService userService;

    public LoginController(UserIoc userIoc) {

        this.userService = UserIoc.createService();

    }



}
