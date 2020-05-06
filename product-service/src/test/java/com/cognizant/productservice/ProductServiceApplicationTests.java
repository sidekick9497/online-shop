package com.cognizant.productservice;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.*;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;


import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.test.context.junit4.SpringRunner;


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
	
	Category cat;
	CategoryModel catM ;
	Product prod ;
	ProductModel expectedOutput;
	
	@BeforeEach
    public void init() {

		cat = new Category(201, "cat 1", "breif", null);
		catM = new CategoryModel(201, "cat 1", "breif");
		prod = new Product(101,"Item 1", 10000,"item 1 description", cat);
		expectedOutput= new ProductModel(101,"Item 1", 10000,"item 1 description", catM);
		
		when(prodrepo.findById(101)).thenReturn(Optional.of(prod));
    }
	
	@Test
	void getProductDetailsTest() {
		
		assertEquals(expectedOutput.getItem_id(),prodservice.getProductDetails(101).getItem_id());
		assertEquals(expectedOutput.getItem_name(),prodservice.getProductDetails(101).getItem_name());

//		assertNotEquals(expectedOutput,prodservice.getProductDetails(101));
//		assertSame(expectedOutput, prodservice.getProductDetails(101));
//		assertNotNull(prodservice.getProductDetails(101));
	}
}
