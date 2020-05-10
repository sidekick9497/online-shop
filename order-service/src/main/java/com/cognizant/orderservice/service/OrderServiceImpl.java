package com.cognizant.orderservice.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cognizant.orderservice.entity.OrderEntity;
import com.cognizant.orderservice.model.OrderModel;
import com.cognizant.orderservice.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepository orderRepo;
	
	
	@Override
	public boolean addOrder(OrderModel orderModel) {
		OrderEntity order =  new OrderEntity();
		order.setUserId(orderModel.getUserId());
		order.setOrderAmount(orderModel.getOrderAmount());
		order.setOrderDate(orderModel.getOrderDate());
		order.setOrderStatus(orderModel.getOrderStatus());
		order.setOrderType(orderModel.getOrderType());
		order.setItemId(orderModel.getItemId());
		order = orderRepo.save(order);
//		orderModel.setOrderId(order.getOrderId());
		
		return true;
	}

	@Override
	public List<OrderModel> getUsersOrders(int userId) {
		
		List<OrderModel> allOrders = new ArrayList();
		Iterable<OrderEntity> allOrdersEntity = orderRepo.findByUserId(userId);
		Iterator<OrderEntity> itr = allOrdersEntity.iterator();
		while(itr.hasNext()) {
			OrderEntity temp = itr.next();
			OrderModel orderModel = new OrderModel(
													temp.getOrderId(),
													temp.getOrderAmount(),
													temp.getOrderStatus(),
													temp.getOrderDate(),
													temp.getUserId(),
													temp.getOrderType(),
													temp.getItemId(),
													temp.getItemQuantity()
												   );
			
			allOrders.add(orderModel);
		}
		
		
		return allOrders;
	}

	@Override
	public List<OrderModel> allOrders() {
		
		List<OrderModel> allOrders = new ArrayList();
		Iterable<OrderEntity> allOrdersEntity = orderRepo.findAll();
		Iterator<OrderEntity> itr = allOrdersEntity.iterator();
		while(itr.hasNext()) {
			OrderEntity temp = itr.next();
			OrderModel orderModel = new OrderModel(
													temp.getOrderId(),
													temp.getOrderAmount(),
													temp.getOrderStatus(),
													temp.getOrderDate(),
													temp.getUserId(),
													temp.getOrderType(),
													temp.getItemId(),
													temp.getItemQuantity()
												   );
			
			allOrders.add(orderModel);
		}
		
		
		return allOrders;
	}

	@Override
	public OrderModel getOrder(int id) {
		// TODO Auto-generated method stub
		OrderModel orderModel = null;
		Optional res = orderRepo.findById(id);
		if(res.isPresent()) {
			OrderEntity orderEntity = (OrderEntity) res.get();
			orderModel = new OrderModel(
										orderEntity.getOrderId(),
										orderEntity.getUserId(),
										orderEntity.getItemId(),
										orderEntity.getOrderDate(),
										orderEntity.getOrderAmount(),
										orderEntity.getItemQuantity(),
										orderEntity.getOrderStatus(),
										orderEntity.getOrderType()
									   );
		}
		return orderModel;
	}

}
