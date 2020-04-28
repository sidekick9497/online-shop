package com.cognizant.productservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserProductController {
    @PostMapping("product/add/:id/:quantity")
    public ResponseEntity<Boolean> addProductToCart(@PathVariable Integer id, @PathVariable Integer quantity)
    {
        return null;
    }
    @GetMapping("product/view")
    public ResponseEntity<Object> viewAllProducts()
    {
        return null;
    }
}
