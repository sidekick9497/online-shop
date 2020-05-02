package com.cognizant.orderservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface IOrderController {
    public String testConfigServer();
    public ResponseEntity<Object> getAllOrders();
    public ResponseEntity<Boolean> addOneOrder();
    public ResponseEntity<Boolean> acceptOrder(@PathVariable Integer id);
    public ResponseEntity<Boolean> rejectOrder(@PathVariable Integer id);
}
