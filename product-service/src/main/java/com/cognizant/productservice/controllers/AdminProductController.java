package com.cognizant.productservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminProductController implements  IAdminProductController {
    @Autowired
    private Environment env;
    @Override
    @GetMapping("/testServer")
    public String testConfigServer()
    {
        return env.getProperty("msg","no value");
    }

    @PostMapping("/productAdd")
    public ResponseEntity<Boolean> addProduct()//add Product parameter
    {
        // implement
        return  null;
    }
    @GetMapping("/product/:id")
    public  ResponseEntity<Object> getProduct(@PathVariable Integer id)
    {
        return null;
    }
    @PutMapping("/product/update")
    public ResponseEntity<Boolean> updateProduct()//add product as parameter
    {
        return null;
    }
    @DeleteMapping("/product/:id")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable Integer id)
    {
        return null;
    }
}
