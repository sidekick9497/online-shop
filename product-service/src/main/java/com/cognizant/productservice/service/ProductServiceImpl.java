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

		List<ProductModel> allProducts = new ArrayList<ProductModel>();
		Iterable<Product> allProd = productrepo.findAll();
		Iterator<Product> itr = allProd.iterator();
		while (itr.hasNext()) {
			Product products = (Product) itr.next();
			Category category = products.getAllCategory();
			CategoryModel categories = new CategoryModel(category.getCategory_id(), category.getCategory_name(),
					category.getCategory_brief());
			ProductModel productm = new ProductModel(products.getItem_id(), products.getItem_name(),
					products.getItem_price(), products.getItem_description(), categories);
			allProducts.add(productm);
		}
		System.out.println(allProducts);
		return allProducts;
	}

	

}
