package com.cts.onlineordering.cartservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.onlineordering.cartservice.entity.Cart;
import com.cts.onlineordering.cartservice.model.CartModel;
import com.cts.onlineordering.cartservice.repository.CartRepository;

@Service
public class CartServiceImpl implements ICartService {
	
	@Autowired
	CartRepository cartrepo;
	
	@Override
	public void addProduct(CartModel product)
	{
		Cart cart=new Cart();
		cart.setUser_id(product.getUser_id());
		cart.setItem_id(product.getItem_id());
		cart.setItem_quantity(product.getItem_quantity());
		cart = cartrepo.save(cart);
		
	}

	@Override
	public List<CartModel> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		this.cartrepo.deleteById(id);
		
		
	}

	@Override
	public void increaseQuantity(Integer id, Integer quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decreaseQuantity(Integer id, Integer quantity) {
		// TODO Auto-generated method stub
		
	}

}
