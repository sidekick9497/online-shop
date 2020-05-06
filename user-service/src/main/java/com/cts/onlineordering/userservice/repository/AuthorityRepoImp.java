package com.cts.onlineordering.userservice.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cts.onlineordering.userservice.entity.Authorities;

@Repository
@Transactional
public class AuthorityRepoImp implements AuthorityRepository {

	@PersistenceContext
	private EntityManager em;
	
	public void save(Authorities auth) {
		
		this.em.persist(auth);

	}

}
