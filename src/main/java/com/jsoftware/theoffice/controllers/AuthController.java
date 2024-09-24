package com.jsoftware.theoffice.controllers;

import com.jsoftware.theoffice.models.User;
import com.jsoftware.theoffice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String login (@RequestBody User user){
        return userService.verifyUser(user);
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userService.register(user);
    }
}
