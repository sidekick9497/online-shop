package com.cts.onlineordering.cartservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.cts.onlineordering.cartservice.model.ProductModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.client.RestTemplate;

import com.cts.onlineordering.cartservice.entity.Cart;
import com.cts.onlineordering.cartservice.model.CartModel;
import com.cts.onlineordering.cartservice.model.ItemModel;
import com.cts.onlineordering.cartservice.repository.CartRepository;
import springfox.documentation.swagger2.mappers.ModelMapper;

@Service
public class CartServiceImpl implements ICartService {
	
	@Autowired
	CartRepository cartrepo;
	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Override
	public Boolean addProduct(CartModel product)
	{
		Cart cart=new Cart();
		cart.setUserId(product.getUser_id());
		cart.setItem_id(product.getItem_id());
		cart.setItem_quantity(product.getItem_quantity());
		cart = cartrepo.save(cart);
		return true;
		
	}

	@Override
	public CartModel getAllProducts(Integer userId) {
		List<Cart> cartItems = this.cartrepo.findCartsByUserId(userId);
		CartModel cartModel = new CartModel();
		cartModel.setLtemlist(new ArrayList<ItemModel>());
		cartModel.setUser_id(userId);
		for(Cart cart: cartItems)
		  {
			Integer id = cart.getItem_id();
			ProductModel productModel = restTemplate.getForObject("http://localhost:8282/product/"+id,ProductModel.class);// just give the url for the product
			 ItemModel itemModel = new ItemModel();
			 itemModel.setItem_quantity(cart.getItem_quantity());
			 itemModel.setItem_name(productModel.getItem_name());
			 itemModel.setItem_id(productModel.getItem_id());
			 itemModel.setItem_descrption(productModel.getItem_description());
			 itemModel.setItem_price(productModel.getItem_price());
			  itemModel.setItem_quantity(cart.getItem_quantity());

			  cartModel.getLtemlist().add(itemModel);
			}
		return cartModel;

	}

	@Override
	public Boolean deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		this.cartrepo.deleteById(id);
		return true;

	}

	@Override
	public ProductModel getProduct() {
		ProductModel productModel = restTemplate.getForObject("http://localhost:8282/product/2",ProductModel.class);// just give the url for the product
		return productModel;
	}
	
	/*@Override
	public Boolean increaseQuantity(Integer id, Integer quantity) {
		Cart cart = cartrepo.findById(id).get();
		cart.setItem_quantity(cart.getItem_quantity() + quantity);
		this.cartrepo.save(cart);
		return true;

	}

	@Override
	pu blic Boolean decreaseQuantity(Integer id, Integer quantity) {
		Cart cart = cartrepo.findById(id).get();
		System.out.println(cart.getItem_quantity());
		if (cart.getItem_quantity() >= quantity) {
			cart.setItem_quantity(cart.getItem_quantity() - quantity);
			this.cartrepo.save(cart);
			return true;
		}
		return false;
		
	}*/

}
