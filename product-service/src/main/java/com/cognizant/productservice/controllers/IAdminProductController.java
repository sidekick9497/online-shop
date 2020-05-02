package com.cognizant.productservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface IAdminProductController {
    public String testConfigServer();
    public ResponseEntity<Boolean> addProduct();
    public  ResponseEntity<Object> getProduct(@PathVariable Integer id);
    public ResponseEntity<Boolean> updateProduct();
    public ResponseEntity<Boolean> deleteProduct(@PathVariable Integer id);
}
