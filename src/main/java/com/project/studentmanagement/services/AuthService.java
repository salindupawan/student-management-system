package com.project.studentmanagement.services;

import com.project.studentmanagement.entities.User;

public interface AuthService {
    User register(User user);
    String verify(String username, String password);
}
