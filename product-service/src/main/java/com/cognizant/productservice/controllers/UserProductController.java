package com.cognizant.productservice.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.productservice.model.ProductModel;
import com.cognizant.productservice.service.ProductService;


@RestController
public class UserProductController {
	

	
	@Autowired
	ProductService productService;
	

	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    

    @PostMapping("product/add/:id/:quantity")
    public ResponseEntity<Boolean> addProductToCart(@PathVariable Integer id, @PathVariable Integer quantity)
    {
        return null;
    }
   
    @GetMapping("/product/view")
    public ResponseEntity<List<ProductModel>> viewAllProducts()
    {
		return null;
    	
    }
    
  

    

  

}
