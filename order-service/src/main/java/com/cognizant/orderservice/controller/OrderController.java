package com.cognizant.orderservice.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cognizant.orderservice.model.OrderModel;
import com.cognizant.orderservice.service.OrderService;

@RestController
public class OrderController implements IOrderController {
	
	private OrderService orderService;
	
	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    

    @GetMapping("orders/:id")
    public ResponseEntity<Object> getOneOrder() //add orders object
    {
     
        return  null;
    }

    @Override
    public String testConfigServer() {
        return null;
    }

    @GetMapping("orders")
    public ResponseEntity<Object> getAllOrders()//add ordersObject
    {
        return null;
    }
    @PostMapping("orders")
    public ResponseEntity<Boolean> addOneOrder() //add orders Object in the method parameter
    {
        return  null;
    }

    @PutMapping("orders/action/accept/:id")
    public ResponseEntity<Boolean> acceptOrder(@PathVariable Integer id)
    {
        return null;
    }

    @PutMapping("orders/action/reject")
    public ResponseEntity<Boolean> rejectOrder(@PathVariable Integer id)
    {
        return null;
    }

    @GetMapping("userorders")
	public ResponseEntity<List<OrderModel>> getUserOrders(@PathVariable Integer userId) {
		// TODO Auto-generated method stub
    	List<OrderModel> allOrders = orderService.getUsersOrders(userId);
//		return ResponseEntity<List<OrderModel>>(allOrders, HttpStatus.OK);
    	return null;
	}
}
