package com.cts.onlineordering.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.onlineordering.userservice.entity.Authorities;
import com.cts.onlineordering.userservice.repository.AuthorityRepository;

@Service

public class AuthoritiesService {
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	public void saveauthority(Authorities role) {
		this.authorityRepository.save(role);

  }
}
