package com.cts.onlineordering.cartservice.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.onlineordering.cartservice.entity.Cart;
import com.cts.onlineordering.cartservice.model.CartModel;
import com.cts.onlineordering.cartservice.model.ItemModel;
import com.cts.onlineordering.cartservice.repository.CartRepository;

@Service
public class CartServiceImpl implements ICartService {
	
	@Autowired
	CartRepository cartrepo;
	
	@Override
	public Boolean addProduct(CartModel product)
	{
		Cart cart=new Cart();
		cart.setUser_Id(product.getUser_id());
		cart.setItem_id(product.getItem_id());
		cart.setItem_quantity(product.getItem_quantity());
		cart = cartrepo.save(cart);
		return true;
		
	}

	@Override
	public List<CartModel> getAllProducts() {
		
		return null;
	}

	@Override
	public Boolean deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		this.cartrepo.deleteById(id);
		return true;

	}
	
	@Override
	public Boolean increaseQuantity(Integer id, Integer quantity) {
		Cart cart = cartrepo.findById(id).get();
		cart.setItem_quantity(cart.getItem_quantity() + quantity);
		this.cartrepo.save(cart);
		return true;

	}

	@Override
	public Boolean decreaseQuantity(Integer id, Integer quantity) {
		Cart cart = cartrepo.findById(id).get();
		System.out.println(cart.getItem_quantity());
		if (cart.getItem_quantity() >= quantity) {
			cart.setItem_quantity(cart.getItem_quantity() - quantity);
			this.cartrepo.save(cart);
			return true;
		}
		return false;
		
	}

}
