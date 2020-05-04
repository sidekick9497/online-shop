package com.cognizant.orderservice.repository;

import java.util.List;

import com.cognizant.orderservice.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
	List<OrderEntity> findByUserId(int userId);
}
