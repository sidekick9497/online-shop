package com.cts.onlineordering.cartservice.controller;

import com.cts.onlineordering.cartservice.model.CartModel;
import com.cts.onlineordering.cartservice.model.ProductModel;
import com.cts.onlineordering.cartservice.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    @Autowired
    private ICartService cartService;



    @GetMapping("/cart/testRest")
    public  ResponseEntity<ProductModel> testRestTemplate()
    {
        ProductModel productModel = cartService.getProduct();
        return new ResponseEntity<>(productModel,HttpStatus.OK);

    }
    @GetMapping("/cart/items/{id}")
    public ResponseEntity<CartModel> getCartItems(@PathVariable Integer id)
    {

                CartModel cartModel = cartService.getAllProducts(id);

                return new ResponseEntity<>(cartModel,HttpStatus.OK);
        
    }

    @PostMapping("/cart/addItems")
    public ResponseEntity<Boolean> addCartItem(@RequestBody CartModel item)
    {
        cartService.addProduct(item);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
    @PutMapping("/cart/updateQuantity")
    public ResponseEntity<Boolean> addQuantity(@RequestBody CartModel item)
    {
        cartService.addProduct(item);
        return new ResponseEntity<Boolean>(true,HttpStatus.OK);
    }


    @DeleteMapping("/cart/{itemId}")
    public ResponseEntity<Boolean> deleteItem(@PathVariable Integer itemId)
    {
        cartService.deleteProduct(itemId);
        return new ResponseEntity<Boolean>(true,HttpStatus.OK);
    }
}
