package com.project.studentmanagement.controllers;

import com.project.studentmanagement.entities.Course;
import com.project.studentmanagement.entities.User;
import com.project.studentmanagement.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(path = "/register")
    public User register(@Valid @RequestBody User user) {
        return authService.register(user);
    }

    @PostMapping(path = "/login")
    public String login(@Valid @RequestBody User user) {
        return authService.verify(user.getUsername(), user.getPassword());
    }
}
