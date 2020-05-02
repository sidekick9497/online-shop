package com.cts.onlineordering.userservice.service;

import com.cts.onlineordering.userservice.model.UserModel;

public interface UserService {
	
	UserModel validateUser(UserModel userModel);
	
	UserModel addUser(UserModel userModel);

}
