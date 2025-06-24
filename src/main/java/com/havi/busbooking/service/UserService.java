package com.havi.busbooking.service;


import org.springframework.stereotype.Service;

import com.havi.busbooking.model.User;
import com.havi.busbooking.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String addUser(User user) {
        if(userRepository.findByUserName(user.getEmail()) != null) {
            return "Email";
        }
        user.setRole("USER");
        user.setEmail(user.getEmail().toLowerCase());
        user.setPassword(user.getPassword().toLowerCase());

        userRepository.save(user);

        return "User added successfully";
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByUserName(User user) {
       User loggedUser =   userRepository.findByUserName(user.getEmail().toLowerCase());
        if(loggedUser != null) {
            if (loggedUser.getPassword().equalsIgnoreCase(user.getPassword())){
                loggedUser.setPassword("");
                return loggedUser;
            }
        }
        return null;
    }
}
