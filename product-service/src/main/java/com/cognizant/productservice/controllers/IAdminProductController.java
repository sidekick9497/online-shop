package com.cognizant.productservice.controllers;

import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@Api(value = "ProductAdminController",description = "for crud operation of products with admin")
public interface IAdminProductController {
    public String testConfigServer();
    public ResponseEntity<Boolean> addProduct();
    public  ResponseEntity<Object> getProduct(@PathVariable Integer id);
    public ResponseEntity<Boolean> updateProduct();
    public ResponseEntity<Boolean> deleteProduct(@PathVariable Integer id);
}
