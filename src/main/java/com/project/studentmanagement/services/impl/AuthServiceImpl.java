package com.project.studentmanagement.services.impl;

import com.project.studentmanagement.entities.User;
import com.project.studentmanagement.repositories.UserRepository;
import com.project.studentmanagement.services.AuthService;
import com.project.studentmanagement.services.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder encoder;
    private final JWTService jwtService;

//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @Override
    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public String verify(String username, String password) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        if(authenticate.isAuthenticated()) {
            return jwtService.createJWT(username);
        }
        return "fail";
    }
}
