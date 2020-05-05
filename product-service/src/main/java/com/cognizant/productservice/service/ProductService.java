package com.cognizant.productservice.service;

import java.util.List;

import com.cognizant.productservice.entity.Product;
import com.cognizant.productservice.model.ProductModel;

public interface ProductService {

	List<ProductModel> getAllProducts();
	ProductModel getProductDetails(Integer productId);
	boolean addProduct(ProductModel product);
	boolean updateProduct(ProductModel product);
	boolean deleteProduct(Integer id);
}


