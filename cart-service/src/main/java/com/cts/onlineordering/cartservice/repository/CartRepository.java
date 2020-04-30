package com.cts.onlineordering.cartservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.onlineordering.cartservice.entity.Cart;



public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	List<Cart> findByUserId(Integer id);

}
