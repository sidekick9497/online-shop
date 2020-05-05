package com.cognizant.productservice.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.productservice.entity.Category;
import com.cognizant.productservice.entity.Product;
import com.cognizant.productservice.model.CategoryModel;
import com.cognizant.productservice.model.ProductModel;
import com.cognizant.productservice.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productrepo;

	@Override
	public List<ProductModel> getAllProducts() {
		List<ProductModel> allProd = new ArrayList();
		Iterable<Product> allProducts = productrepo.findAll();
		Iterator<Product> itr = allProducts.iterator();
		while(itr.hasNext())
		{
			Product Products = (Product) itr.next();
			Category category = Products.getAllCategory();
			CategoryModel  categories = new CategoryModel(category.getCategory_id(),category.getCategory_name(),category.getCategory_brief());
			ProductModel Prod = new ProductModel(Products.getItem_id(),Products.getItem_name(),Products.getItem_price(),Products.getItem_description(), categories);
			allProd.add(Prod);
		}
		
		return allProd;
	}

	@Override
	public ProductModel getProductDetails(Integer productId) {

		ProductModel prod = null;
		Optional res = productrepo.findById(productId);
		if (res.isPresent()) {
			Product product = (Product) res.get();
			Category category = product.getAllCategory();
			CategoryModel categories = new CategoryModel(category.getCategory_id(), category.getCategory_name(),
					category.getCategory_brief());
			prod = new ProductModel(product.getItem_id(), product.getItem_name(), product.getItem_price(),
					product.getItem_description(), categories);
		}
		return prod;
	}

	@Override
	public ProductModel addProduct(ProductModel product) {
		CategoryModel category = product.getAllCategory();
		Category allCategory = new Category(category.getCategory_id(),category.getCategory_name(),category.getCategory_brief(), null);
		Product prod = new Product();
		prod.setItem_id(0);
		prod.setItem_name(product.getItem_name());
		prod.setItem_price(product.getItem_price());
		prod.setItem_description(product.getItem_description());
		prod.setAllCategory(allCategory);
		prod = productrepo.saveAndFlush(prod);
		product.setItem_id(prod.getItem_id());
		return product;
		
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		Product prod = new Product();
        prod.setItem_id(product.getItem_id());
		prod.setItem_name(product.getItem_name());
		prod.setItem_price(product.getItem_price());
		prod.setItem_description(product.getItem_description());
	    this.productrepo.save(prod);
		
	}

	@Override
	public boolean deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		Product prod=new Product();
		this.productrepo.delete(prod);
		return true;
	}

	

}
