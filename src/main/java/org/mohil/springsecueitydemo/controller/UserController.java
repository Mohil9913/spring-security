package org.mohil.springsecueitydemo.controller;

import org.mohil.springsecueitydemo.model.User;
import org.mohil.springsecueitydemo.service.JwtService;
import org.mohil.springsecueitydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("register")
    public User registerUser(@RequestBody User user) {
        System.out.println("\n\n\nRegistering user in Controller: " + user);
        return userService.saveUser(user);
    }

    @PostMapping("login")
    public String login(@RequestBody User user) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        }else {
            return "failed";
        }
    }
}
