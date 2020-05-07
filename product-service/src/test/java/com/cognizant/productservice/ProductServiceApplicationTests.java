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
	
	Category cat;
	CategoryModel catM ;
	Product prod ;
	ProductModel expectedOutput;
	
	@BeforeEach
    public void init() {

    }
	
	@Test
	void getProductDetailsTest() {
		cat = new Category(201, "cat 1", "breif", null);
		catM = new CategoryModel(201, "cat 1", "breif");
		prod = new Product(101,"Item 1", 10000,"item 1 description", cat);
		expectedOutput= new ProductModel(101,"Item 1", 10000,"item 1 description", catM);
		when(prodrepo.findById(101)).thenReturn(Optional.of(prod));
		
		assertEquals(expectedOutput.getItem_id(),prodservice.getProductDetails(101).getItem_id());
		assertEquals(expectedOutput.getItem_name(),prodservice.getProductDetails(101).getItem_name());

//		assertNotEquals(expectedOutput,prodservice.getProductDetails(101));
//		assertSame(expectedOutput, prodservice.getProductDetails(101));
//		assertNotNull(prodservice.getProductDetails(101));
	}
	
	@Test
	void addProductTest() {
		cat = new Category(201, "cat 1", "breif", null);
		catM = new CategoryModel(201, "cat 1", "breif");
		
		ProductModel inputP = new ProductModel();
		inputP.setItem_name("Item 1");
		inputP.setItem_price(1000);
		inputP.setItem_description("item 1 description");
		inputP.setAllCategory(catM);
		
		
		prod = new Product(0,"Item 1", 10000,"item 1 description", cat);
		Product expectedProd = new Product(101,"Item 1", 10000,"item 1 description", cat);
		
		when(prodrepo.save(prod)).thenReturn(expectedProd);
		
		
		assertEquals(true, prodservice.addProduct(inputP));
	}
	
	
	@Test
	void updateProductTest() {
		cat = new Category(201, "cat 1", "breif", null);
		catM = new CategoryModel(201, "cat 1", "breif");
		Product expectedProd = new Product(101,"Item 1", 10000,"item 1 updated description", cat);
		Product inputProd = new Product(101,"Item 1", 10000,"item 1 description", cat);
		ProductModel inputProdModel = new ProductModel(101,"Item 1", 10000,"item 1 description", catM);
		when(prodrepo.save(inputProd)).thenReturn(expectedProd);
		assertEquals(true, prodservice.updateProduct(inputProdModel));
		
	}
	
	@Test
	void allProductsTest() {
		cat = new Category(201, "cat 1", "breif", null);
		Category cat2 = new Category(202, "cat 2", "breif 2", null);
		
		catM = new CategoryModel(201, "cat 1", "breif");
		CategoryModel catM2 = new CategoryModel(202, "cat 2", "breif 2");
		
		List<Product> allProd = new ArrayList();
		Product inputProd1 = new Product(101,"Item 1", 10000,"item 1 description", cat);
		Product inputProd2 = new Product(102,"Item 2", 1245,"item 2 des", cat2);
		allProd.add(inputProd1);
		allProd.add(inputProd2);
		
		List<ProductModel> allProdModel = new ArrayList();
		ProductModel ProdModel = new ProductModel(101,"Item 1", 10000,"item 1 description", catM);
		ProductModel ProdModel2 = new ProductModel(102,"Item 2", 1245,"item 2 des", catM2);
		allProdModel.add(ProdModel);
		allProdModel.add(ProdModel2);
		
		when(prodrepo.findAll()).thenReturn(allProd);
		int i=0;
		for(ProductModel p: allProdModel) {
			assertEquals(p.getItem_id(), prodservice.getAllProducts().get(i).getItem_id());
			i++;
		}
		
	}
}
