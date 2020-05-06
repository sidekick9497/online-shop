package com.cts.onlineordering.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.onlineordering.userservice.entity.UserEntity;



public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	
	//UserEntity findByUserNameAndPassword(String Username , String Password);

}
