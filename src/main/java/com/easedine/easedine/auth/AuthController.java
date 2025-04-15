package com.easedine.easedine.auth;


import com.easedine.easedine.dto.LoginRequestDTO;
import com.easedine.easedine.dto.RegisterRequestDTO;
import com.easedine.easedine.exceptions.UserNameNotFoundException;
import com.easedine.easedine.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequestDTO requestDTO) {
        return ResponseEntity.ok(authService.register(requestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO loginRequestDTO) throws UserNameNotFoundException {
        return ResponseEntity.ok(authService.login(loginRequestDTO.getUserName(), loginRequestDTO.getPassword()));
    }
}