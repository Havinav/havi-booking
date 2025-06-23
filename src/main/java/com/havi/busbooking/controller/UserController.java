package com.havi.busbooking.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.havi.busbooking.model.ErrorResponseDTO;
import com.havi.busbooking.model.User;
import com.havi.busbooking.service.UserService;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user) {
       return ResponseEntity.ok(userService.addUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loingUser(@RequestBody User user) {
        User loggedUser = userService.getUserByUserName(user);
        if(loggedUser == null) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorResponseDTO(401, "Unauthorized", "Invalid username or password"));
        }
        return ResponseEntity.ok(loggedUser);
    }

}
