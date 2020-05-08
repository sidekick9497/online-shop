package com.cts.onlineordering.cartservice.service;

import java.util.List;


import com.cts.onlineordering.cartservice.model.CartModel;
import org.springframework.stereotype.Service;


public interface ICartService {
	
	CartModel getAllProducts();
	public Boolean addProduct(CartModel product);
	public Boolean deleteProduct(Integer id);
	public Boolean increaseQuantity(Integer id, Integer quantity);
	public Boolean decreaseQuantity(Integer id, Integer quantity);
	
	

}
