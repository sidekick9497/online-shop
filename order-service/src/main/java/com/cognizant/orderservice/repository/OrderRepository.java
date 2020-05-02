package com.cognizant.orderservice.repository;

import java.util.List;

import com.cognizant.orderservice.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{
	List<OrderEntity> findByUserId(int userId);
}
