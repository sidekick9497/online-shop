package com.cognizant.orderservice.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cognizant.orderservice.model.OrderModel;
import com.cognizant.orderservice.service.OrderService;


@RestController
public class OrderController implements IOrderController {
	
	@Autowired
	private OrderService orderService;
	
	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    

    @Override
    public String testConfigServer() {
        return null;
    }

    

    @GetMapping("/getOrder/{id}")
    public ResponseEntity<OrderModel> getOneOrder(@PathVariable("id") Integer id) //add orders object
    {
    	OrderModel response = orderService.getOrder(id);
        return new ResponseEntity<OrderModel>(response, HttpStatus.OK);
    }

    
    @GetMapping("/allOrders")
    public ResponseEntity<List<OrderModel>> getAllOrders()//add ordersObject
    {	
    	List<OrderModel> allOrders = orderService.allOrders();
        return new ResponseEntity<List<OrderModel>>(allOrders, HttpStatus.OK);
    }
    @PostMapping("/addOrder")
    public ResponseEntity<Boolean> addOneOrder(@RequestBody OrderModel orderModel) //add orders Object in the method parameter
    {
        orderService.addOrder(orderModel);
        
        ResponseEntity<Boolean> response = new ResponseEntity<>(true, HttpStatus.OK);
        return  response;
    }

    @PutMapping("/orders/action/accept/{id}")
    public ResponseEntity<Boolean> acceptOrder(@PathVariable("id") Integer id)
    {
        return null;
    }

    @PutMapping("/orders/action/reject")
    public ResponseEntity<Boolean> rejectOrder(@PathVariable Integer id)
    {
        return null;
    }

    @GetMapping("/userOrders/{id}")
	public ResponseEntity<List<OrderModel>> getUserOrders(@PathVariable("id") Integer userId) {
		// TODO Auto-generated method stub
    	List<OrderModel> allOrders = orderService.getUsersOrders(userId);
		return new ResponseEntity<List<OrderModel>>(allOrders, HttpStatus.OK);
	}



	@Override
	@DeleteMapping("/deleteOrder/{id}")
	public ResponseEntity<Boolean> deleteOrder(@PathVariable("id") Integer id) {
		// TODO Auto-generated method stub
		orderService.deleteOrder(id);
		ResponseEntity<Boolean> response = new ResponseEntity<>(true, HttpStatus.OK);
		return response;
	}
}
