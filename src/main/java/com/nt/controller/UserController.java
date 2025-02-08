package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.entity.User;
import com.nt.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // Display login form
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    // Handle login form submission
    @PostMapping("/login")
    public String handleLogin(User user, Model model) {
        User userObj = userService.getUser(user.getEmail(), user.getPwd());
        if (userObj == null) {
            model.addAttribute("emsg", "Invalid Credentials");
            return "index";  // Stay on the login page
        } else {
            model.addAttribute("msg", userObj.getName() + " Welcome");
            return "dashboard";
        }
    }

    // Display registration form
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "registerView";
    }

    // Handle registration form submission
    @PostMapping("/register")
    public String handleRegister(User user, Model model) {
        boolean saveUser = userService.saveUser(user);
        if (saveUser) {
            model.addAttribute("smsg", "User registered successfully");
        } else {
            model.addAttribute("emsg", "Registration failed");
        }
        return "registerView";  // Stay on the registration page
    }

    // Logout user and go back to login page
    @GetMapping("/logout")
    public String logout(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }
}
