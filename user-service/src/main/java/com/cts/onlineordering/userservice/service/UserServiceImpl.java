package com.cts.onlineordering.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cts.onlineordering.userservice.entity.UserEntity;
import com.cts.onlineordering.userservice.model.UserModel;
import com.cts.onlineordering.userservice.repository.UserRepository;

import lombok.extern.java.Log;


public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository user;
	
	@Override
	public UserModel validateUser(UserModel userModel) {
	
		UserEntity userEntity = user.findByUsernameAndPassword(userModel.getUserName(),userModel.getUserPassword() );
		return userModel = new UserModel(userEntity.getUserId(),userEntity.getUserName(),userEntity.getUserPassword(),userEntity.getUserMobile(),userEntity.getUserRole());
		
		}

	@Override
	public UserModel addUser(UserModel userModel) {
		UserEntity userEntity=new UserEntity();
		userEntity.setUserId(0);
		userEntity.setUserPassword(userModel.getUserPassword());
		userEntity.setUserName(userModel.getUserName());
		userEntity.setUserMobile(userModel.getUserMobile());
		userEntity.setUserRole(userModel.getUserRole());
		userEntity = user.save(userEntity);
		return userModel;
	}

}
