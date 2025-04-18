package com.HiveTask.controller;

import com.HiveTask.common.ioc.UserIoc;
import com.HiveTask.domain.entity.User;
import com.HiveTask.domain.services.UserService;
import com.HiveTask.domain.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/register")

public class LoginController {
    private UserService userService;

    public LoginController(UserIoc userIoc) {
        this.userService = UserIoc.createService();
    }
    @GetMapping("")
    public String mostrarFormulario(Model model) {
        model.addAttribute("user", new User());
        return "login"; // tu vista con el formulario
    }

    @PostMapping("")
    public String registrarUsuario(@ModelAttribute("user") User user) {
        userService.userRegister(user);
        return "userPage"; // o donde quieras redirigir
    }

}