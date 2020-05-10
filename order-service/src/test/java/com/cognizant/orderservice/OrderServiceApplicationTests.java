package com.cognizant.orderservice;


import org.springframework.boot.test.context.SpringBootTest;

//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.*;
//import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

//import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;


import org.junit.runner.RunWith;
//import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.orderservice.entity.OrderEntity;
import com.cognizant.orderservice.model.OrderModel;
import com.cognizant.orderservice.repository.OrderRepository;
import com.cognizant.orderservice.service.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Date;



@RunWith(SpringRunner.class)
@SpringBootTest
class OrderServiceApplicationTests {

	@Autowired
	private OrderService orderService;
	
	@MockBean
	private OrderRepository orderRepo;
	
	@Test
	void contextLoads() {
		assertEquals(1,1);
	}
	
	@Test
	void AddOrderTest() {
		Date d= new Date();
		d.setDate(12);
		d.setMonth(02);
		d.setYear(1334);
		OrderModel orderModel = new OrderModel(0, 101, "Cod", d, 1324, "shipping", "101,102", "1,4");
		OrderModel orderOutputModel = new OrderModel(0, 101, "Cod", d, 1324, "shipping", "101,102", "1,4");
		OrderEntity orderEntity = new OrderEntity(0, 101, "Cod", d, 1324, "shipping","101,102", "1,4");
		OrderEntity orderOutputEntity = new OrderEntity(301, 101, "Cod", d, 1324, "shipping", "101,102", "1,4");
		
		when(orderRepo.save(orderEntity)).thenReturn(orderOutputEntity);
		
		assertEquals(true,orderService.addOrder(orderModel));
	}
	
	
	@Test
	void getUsersOrdersTest() {
		
	}
	
	
	
	
	
	

}
