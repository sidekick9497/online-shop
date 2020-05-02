package com.cts.onlineordering.userservice.controllers;

import org.springframework.http.ResponseEntity;

public interface IUserController {

    public String testConfigServer();

    public ResponseEntity<Boolean> signupUser();

    public  ResponseEntity<Boolean> loginUser();
}
