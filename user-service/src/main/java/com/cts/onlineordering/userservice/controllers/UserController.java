package com.cts.onlineordering.userservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private Environment env;
    @GetMapping("/testServer")
    public String testConfigServer()
    {
        return env.getProperty("msg","no value");
    }
    @PostMapping("/signup")
    public ResponseEntity<Boolean> signupUser()
    {
        // user sign-up logic here
        return null;
    }

    @PostMapping("/login")
    public  ResponseEntity<Boolean> loginUser()
    {
        // user log-in user here
        return null;
    }

}
