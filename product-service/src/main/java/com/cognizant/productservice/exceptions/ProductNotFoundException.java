package com.cognizant.productservice.exceptions;

public class ProductNotFoundException extends RuntimeException{
	
	public ProductNotFoundException(String message) {
		
		super(message);
	}
}
