package com.cognizant.productservice.controller;

import com.cognizant.productservice.exceptions.ProductErrorResponse;
import com.cognizant.productservice.model.ProductModel;
import com.cognizant.productservice.service.ProductService;
import com.netflix.ribbon.proxy.annotation.Hystrix;



import lombok.extern.slf4j.Slf4j;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
public class AdminProductController implements  IAdminProductController {
    @Autowired
    private Environment env;

    @Autowired
    private ProductService productService;
    
    @Override
    @GetMapping("/testServer")
    public String testConfigServer()
    {
        return env.getProperty("msg","no value");
    }

    @PostMapping("/productAdd")
    public ResponseEntity<Boolean> addProduct(@RequestBody ProductModel productModel)//add Product parameter
    {
        log.info("Request received to addProduct");
        productService.addProduct(productModel);

        ResponseEntity<Boolean> response = new ResponseEntity<>(true, HttpStatus.OK);
        return  response;
    }
    @GetMapping("/product/{id}")
    public  ResponseEntity<ProductModel> getProduct(@PathVariable Integer id)
    {
        log.info("request received to getProduct");
        ProductModel product = this.productService.getProductDetails(id);
        ResponseEntity<ProductModel> response = new ResponseEntity<>(product,HttpStatus.OK);
        return response;

    }
    @PutMapping("/product/update")
    public ResponseEntity<Boolean> updateProduct(@RequestBody ProductModel productModel)//add product as parameter
    {
        log.info("Request received to update product");
        this.productService.updateProduct(productModel);
        ResponseEntity<Boolean> response = new ResponseEntity<>(true,HttpStatus.OK);
        return response;
    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable Integer id)
    {
        log.info("request received to deleteProduct of Id " + id);
        this.productService.deleteProduct(id);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
    @GetMapping("/products")
    @HystrixCommand(fallbackMethod = "reliable")
    public ResponseEntity<List<ProductModel>> getAllProducts()
    {
        log.info("request received for allProducts");
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
	log.error("Exception :" + error);
	
	return response;
}


}




