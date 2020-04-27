package com.cts.onlineordering.userservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/signup")
    public ResponseEntity<Boolean> signupUser()
    {
        // user sign up logic here
        return null;
    }

    @PostMapping("/login")
    public  ResponseEntity<Boolean> loginUser()
    {
        // user log in user here
        return null;
    }

}
