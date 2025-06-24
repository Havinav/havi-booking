package com.havi.busbooking.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.havi.busbooking.dto.ErrorResponseDTO;
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
    	String msg = userService.addUser(user);
    	
    	if(msg.equals("Email")) {
    		  return  ResponseEntity
    					.status(HttpStatus.NO_CONTENT)
    					.body(new ErrorResponseDTO(204, "Created", msg));
    	}
    	
       return  ResponseEntity
				.status(HttpStatus.OK)
				.body(new ErrorResponseDTO(200, "Created", msg));
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
