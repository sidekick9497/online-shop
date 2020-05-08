package com.cognizant.orderservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@Api(value = "order controller",description = "for accessing orders of users")
public interface IOrderController {
    @ApiOperation(value = "test method for server", response = String.class)
    public String testConfigServer();
    public ResponseEntity<Object> getAllOrders();
    public ResponseEntity<Boolean> addOneOrder();
    public ResponseEntity<Boolean> acceptOrder(@PathVariable Integer id);
    public ResponseEntity<Boolean> rejectOrder(@PathVariable Integer id);
}
