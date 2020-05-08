package com.cts.onlineordering.userservice.controller;

import com.cts.onlineordering.userservice.model.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface IUserController {

    public String testConfigServer();

    public ResponseEntity<Boolean> signupUser(@RequestBody UserModel userModel);

    public  ResponseEntity<Boolean> loginUser();
}
