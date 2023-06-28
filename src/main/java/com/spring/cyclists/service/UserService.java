package com.spring.cyclists.service;

import com.spring.cyclists.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
