package com.cognizant.productservice;

//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.*;
//import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

//import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;


import org.junit.runner.RunWith;
//import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cognizant.productservice.entity.Category;
import com.cognizant.productservice.entity.Product;
import com.cognizant.productservice.model.CategoryModel;
import com.cognizant.productservice.model.ProductModel;
import com.cognizant.productservice.repository.ProductRepository;
import com.cognizant.productservice.service.ProductServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceApplicationTests {
	
	@Autowired
	private ProductServiceImpl prodservice;
	
	@MockBean
	private ProductRepository prodrepo;
	
	Category category1;
	CategoryModel categoryModel1 ;
	Category category2;
	CategoryModel categoryModel2;
	
	Product product ;
	ProductModel expectedOutput;
	ProductModel inputProduct;
	Product expectedProduct;
	
	@BeforeEach
    public void init() {
		category1 = new Category(201, "cat 1", "breif", null);
		categoryModel1 = new CategoryModel(201, "cat 1", "breif");
		product = new Product(101,"Item 1", 10000,"item 1 description", category1);
		expectedOutput= new ProductModel(101,"Item 1", 10000,"item 1 description", categoryModel1);
		
		inputProduct = new ProductModel();
		inputProduct.setItem_name("Item 1");
		inputProduct.setItem_price(1000);
		inputProduct.setItem_description("item 1 description");
		inputProduct.setAllCategory(categoryModel1);
		
		expectedProduct = new Product(101,"Item 1", 10000,"item 1 updated description", category1);
		
		category2 = new Category(202, "cat 2", "breif 2", null);
		categoryModel2 = new CategoryModel(202, "cat 2", "breif 2");
		
		
		
		
    }
	
	@Test
	void getProductDetailsTest() {
		
		when(prodrepo.findById(101)).thenReturn(Optional.of(product));
		
		assertEquals(expectedOutput.getItem_id(),prodservice.getProductDetails(101).getItem_id());
		assertEquals(expectedOutput.getItem_name(),prodservice.getProductDetails(101).getItem_name());

//		assertNotEquals(expectedOutput,prodservice.getProductDetails(101));
//		assertSame(expectedOutput, prodservice.getProductDetails(101));
//		assertNotNull(prodservice.getProductDetails(101));
	}
	
	@Test
	void addProductTest() {
		expectedProduct = new Product(0,"Item 1", 10000,"item 1 description", category1);
		when(prodrepo.save(expectedProduct)).thenReturn(product);
		assertEquals(true, prodservice.addProduct(inputProduct));
	}
	
	
	@Test
	void updateProductTest() {
		when(prodrepo.save(product)).thenReturn(expectedProduct);
		assertEquals(true, prodservice.updateProduct(expectedOutput));	
	}
	
	@Test
	void allProductsTest() {
		
		List<Product> allProd = new ArrayList();

		allProd.add(product);
		product = new Product(102,"Item 2", 1245,"item 2 des", category2);
		allProd.add(product);
		
		List<ProductModel> allProdModel = new ArrayList();
		allProdModel.add(expectedOutput);
		expectedOutput = new ProductModel(102,"Item 2", 1245,"item 2 des", categoryModel2);
		allProdModel.add(expectedOutput);
		
		when(prodrepo.findAll()).thenReturn(allProd);
		int i=0;
		for(ProductModel p: allProdModel) {
			assertEquals(p.getItem_id(), prodservice.getAllProducts().get(i).getItem_id());
			i++;
		}
	}
}
