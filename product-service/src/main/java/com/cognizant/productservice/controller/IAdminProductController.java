package com.cognizant.productservice.controller;

import com.cognizant.productservice.model.ProductModel;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Api(value = "ProductAdminController",description = "for crud operation of products with admin")
public interface IAdminProductController {
    public String testConfigServer();
    public ResponseEntity<Boolean> addProduct(@RequestBody ProductModel productModel);
    public  ResponseEntity<ProductModel> getProduct(@PathVariable Integer id);
    public ResponseEntity<Boolean> updateProduct(@RequestBody ProductModel productModel);
    public ResponseEntity<Boolean> deleteProduct(@PathVariable Integer id);
}
