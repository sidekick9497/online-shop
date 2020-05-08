package com.cognizant.orderservice.controller;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController implements IOrderController {
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
}
