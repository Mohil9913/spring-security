package org.mohil.springsecueitydemo.service;

import org.mohil.springsecueitydemo.dao.UserRepo;
import org.mohil.springsecueitydemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    public User saveUser(User user) {

        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
}
