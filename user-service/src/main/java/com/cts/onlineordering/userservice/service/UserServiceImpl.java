package com.cts.onlineordering.userservice.service;

import com.cts.onlineordering.userservice.entity.Authorities;
import com.cts.onlineordering.userservice.repository.AuthorityRepoImp;
import org.springframework.beans.factory.annotation.Autowired;

import com.cts.onlineordering.userservice.entity.UserEntity;
import com.cts.onlineordering.userservice.model.UserModel;
import com.cts.onlineordering.userservice.repository.UserRepository;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service

public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository user;

	@Autowired
	AuthorityRepoImp authorityRepo;
	@Override
	public UserModel validateUser(UserModel userModel) {
	
	//	UserEntity userEntity = user.findByUserNameAndPassword(userModel.getUserName(),userModel.getUserPassword() );
	//	return userModel = new UserModel(userEntity.getUserId(),userEntity.getUserName(),userEntity.getUserPassword(),userEntity.getUserMobile(),userEntity.getUserRole());
		return null;

		}

	@Override
	public UserModel addUser(UserModel userModel) {
		UserEntity userEntity=new UserEntity();
		userEntity.setUserPassword(userModel.getUserPassword());
		userEntity.setUserName(userModel.getUserName());
		userEntity.setUserMobile(userModel.getUserMobile());
		userEntity.setUserRole(userModel.getUserRole());
		userEntity = user.save(userEntity);
		Authorities role = new Authorities(userEntity.getUserName(),"ROLE_USER");
		authorityRepo.save(role);
		return userModel;
	}

}
