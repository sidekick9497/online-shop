package com.cts.onlineordering.userservice.controller;


import com.cts.onlineordering.userservice.model.UserModel;
import com.cts.onlineordering.userservice.service.UserServiceImpl;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController

public class UserController implements IUserController {

    @Autowired
    private Environment env;

    @Autowired
    private UserServiceImpl userService;
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    
    
    @GetMapping("/testServer")
    public String testConfigServer()
    {
    	
        return env.getProperty("msg","no value");
       
    }
    @PostMapping("/signup")
    public ResponseEntity<Boolean> signupUser(@RequestBody UserModel userModel)
    {
        // user sign-up logic here
    	this.userService.addUser(userModel);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PostMapping("/login")
    public  ResponseEntity<Boolean> loginUser()
    {
        // user log-in user here
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
    @GetMapping("/getUserId")
    public  ResponseEntity<Integer> getUserId(@RequestHeader HttpHeaders headers)
    {
        String user= headers.get("user-name").get(0);
        logger.info("user id is " + user);
        Integer id = this.userService.getUserId(user);
        return new ResponseEntity<>(id,HttpStatus.OK);
    }

}
