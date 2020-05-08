package com.cognizant.productservice.controller;

import com.cognizant.productservice.exceptions.ProductErrorResponse;
import com.cognizant.productservice.model.ProductModel;
import com.cognizant.productservice.service.ProductService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminProductController implements  IAdminProductController {
    @Autowired
    private Environment env;

    @Autowired
    private ProductService productService;
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    @GetMapping("/testServer")
    public String testConfigServer()
    {
        return env.getProperty("msg","no value");
    }

    @PostMapping("/productAdd")
    public ResponseEntity<Boolean> addProduct(@RequestBody ProductModel productModel)//add Product parameter
    {
        logger.info("Request received to addProduct");
        productService.addProduct(productModel);

        ResponseEntity<Boolean> response = new ResponseEntity<>(true, HttpStatus.OK);
        return  response;
    }
    @GetMapping("/product/{id}")
    public  ResponseEntity<ProductModel> getProduct(@PathVariable Integer id)
    {
        logger.info("request received to getProduct");
        ProductModel product = this.productService.getProductDetails(id);
        ResponseEntity<ProductModel> response = new ResponseEntity<>(product,HttpStatus.OK);
        return response;

    }
    @PutMapping("/product/update")
    public ResponseEntity<Boolean> updateProduct(@RequestBody ProductModel productModel)//add product as parameter
    {
        logger.info("Request received to update product");
        this.productService.updateProduct(productModel);
        ResponseEntity<Boolean> response = new ResponseEntity<>(true,HttpStatus.OK);
        return response;
    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable Integer id)
    {
        logger.info("request received to deleteProduct of Id " + id);
        this.productService.deleteProduct(id);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getAllProducts()
    {
        logger.info("request received for allProducts");
        List<ProductModel> allProducts = this.productService.getAllProducts();
        return new  ResponseEntity<List<ProductModel>>(allProducts,HttpStatus.OK);

    }




@ExceptionHandler  // ~catch
public ResponseEntity<ProductErrorResponse> productOperationErrorHAndler(Exception ex) {
	// create error object
	ProductErrorResponse error = new ProductErrorResponse(ex.getMessage(), 
														  HttpStatus.BAD_REQUEST.value(), 
														  System.currentTimeMillis());
	ResponseEntity<ProductErrorResponse> response =
									new ResponseEntity<ProductErrorResponse>(error, HttpStatus.NOT_FOUND);
	logger.error("Exception :" + error);
	
	return response;
}


}




