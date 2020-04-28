package com.cognizant.productservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminProductController {
    @PostMapping("/productAdd")
    public ResponseEntity<Boolean> addProduct()//add Product parameter
    {
        // implement
        return  null;
    }
    @GetMapping("/product/:id")
    public  ResponseEntity<Object> getProduct(@PathVariable Integer id)
    {
        return null;
    }
    @PutMapping("/product/update")
    public ResponseEntity<Boolean> updateProduct()//add product as parameter
    {
        return null;
    }
    @DeleteMapping("/product/:id")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable Integer id)
    {
        return null;
    }
}
