package org.mohil.springsecueitydemo.dao;

import org.mohil.springsecueitydemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}
