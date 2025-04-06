package com.easedine.easedine.service;

import com.easedine.easedine.model.User;
import com.easedine.easedine.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo urepo;

    public String register(User user) {
        if (urepo.existsByEmail(user.getEmail())) {
            return "User already exists";
        }
        urepo.save(user);
        return "Successfully Registered";
    }

    public User login(String email, String password) {
        Optional<User> optionalUser = urepo.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getPassword().equals(password)) {
                return user;
            } else {
                throw new RuntimeException("Incorrect password");
            }
        } else {
            throw new RuntimeException("User not found with email: " + email);
        }
    }

    public User displayUser(String id) {
        Optional<User> userOpt = urepo.findById(id);
        if (userOpt.isPresent()) {
            return userOpt.get();
        } else {
            throw new RuntimeException("Error displaying the User");
        }
    }

    public String deleteUser(String id) {
        if (urepo.existsById(id)) {
            urepo.deleteById(id);
            return "User Deleted Successfully";
        } else {
            return "No such User exists";
        }
    }

    public String forgetPassword(String email, String newPassword) {
        Optional<User> userOpt = urepo.findByEmail(email);
        if (urepo.existsByEmail(email)) {
            User user = userOpt.get();
            user.setPassword(newPassword);
            urepo.save(user);
            return "Password changed successfully";
        } else {
            throw new RuntimeException("No account with given email found");
        }
    }

    public User updateProfile(String id, User updatedUser) {
        Optional<User> userOpt = urepo.findById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setName(updatedUser.getName());
            user.setPhone(updatedUser.getPhone());
            user.setAddress(updatedUser.getAddress());
            user.setEmail(updatedUser.getEmail());
            user.setCategory(updatedUser.getCategory());

            return urepo.save(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
