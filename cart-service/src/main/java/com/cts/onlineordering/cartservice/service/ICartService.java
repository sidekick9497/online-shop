package com.cts.onlineordering.cartservice.service;

import java.util.List;


import com.cts.onlineordering.cartservice.model.CartModel;
import com.cts.onlineordering.cartservice.model.ProductModel;
import org.springframework.stereotype.Service;


public interface ICartService {
	
	CartModel getAllProducts(Integer id);
	public Boolean addProduct(CartModel product);
	public Boolean deleteProduct(Integer id);


	ProductModel getProduct();
}
