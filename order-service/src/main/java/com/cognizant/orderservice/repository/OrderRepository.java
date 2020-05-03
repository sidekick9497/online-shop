package com.cognizant.orderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.orderservice.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{
	List<OrderEntity> findByUserId(int userId);
}
