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


    public String register(User user){
        if(urepo.existsByEmail(user.getEmail())) {
            return "User already exists";
        }
        urepo.save(user);
        return  "SuccessFully Registered";
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


    public User displayUser(int id) {
        User us=urepo.findById(id).orElse(null);
        if(us!=null){
            return us;
        }
        else{
            throw  new RuntimeException("Error displaying the User");
        }

    }

    public String deleteUser(int id) {
        if(urepo.existsById(id)){
            urepo.deleteById(id);
            return "User Deleted Successfully";
        }
        else{
            return  "No such User exists";
        }
    }
}
