package com.spring.cyclists.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
