package com.cognizant.orderservice.service;

import java.util.List;

import com.cognizant.orderservice.model.OrderModel;

public interface OrderService {
	
	OrderModel addOrder(OrderModel orderModel);
	
	List<OrderModel> getUsersOrders(int userId);
	
	List<OrderModel> allOrders();
}