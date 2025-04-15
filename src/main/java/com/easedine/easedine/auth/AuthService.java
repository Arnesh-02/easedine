package com.easedine.easedine.auth;


import com.easedine.easedine.dto.RegisterRequestDTO;
import com.easedine.easedine.exceptions.UserNameNotFoundException;
import com.easedine.easedine.model.User;
import com.easedine.easedine.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    @Lazy
    private UserDetailsService userDetailsService;

    public String login(String username, String password) throws UserNameNotFoundException {
        User user = userRepo.findByUserName(username)
                .orElseThrow(() -> new UserNameNotFoundException("User not found"));

        if (passwordEncoder.matches(password, user.getPassword())) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            return jwtUtil.generateToken(userDetails.getUsername());
        } else {
            throw new BadCredentialsException("Invalid password");
        }
    }

    public String register(RegisterRequestDTO requestDTO) {
        User newUser = new User();
        newUser.setUserId(UUID.randomUUID().toString());
        newUser.setUserName(requestDTO.getUserName());
        newUser.setPassword(passwordEncoder.encode(requestDTO.getPassword()));
        newUser.setName(requestDTO.getName());
        newUser.setPhone(requestDTO.getPhone());
        newUser.setRole(requestDTO.getRole());
        newUser.setAddress(requestDTO.getAddress());
        newUser.setEmail(requestDTO.getEmail());
        newUser.setCategory(requestDTO.getCategory());
        userRepo.save(newUser);

        return "User registered successfully!";
    }

}

