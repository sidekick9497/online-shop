package com.cts.onlineordering.userservice.service;

import com.cts.onlineordering.userservice.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
	
	UserModel validateUser(UserModel userModel);
	
	UserModel addUser(UserModel userModel);

    Integer getUserId(String user);
}
