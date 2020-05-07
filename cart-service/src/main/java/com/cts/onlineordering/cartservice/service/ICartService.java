package com.cts.onlineordering.cartservice.service;

import java.util.List;


import com.cts.onlineordering.cartservice.model.CartModel;



public interface ICartService {
	
	List<CartModel> getAllProducts();
	public void addProduct(CartModel product);
	public void deleteProduct(CartModel product);
	public void increaseQuantity(Integer id, Integer quantity);
	public void decreaseQuantity(Integer id, Integer quantity);
	
	

}
