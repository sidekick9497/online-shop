package com.cts.onlineordering.cartservice.controllers;

import com.cts.onlineordering.cartservice.model.CartModel;
import com.cts.onlineordering.cartservice.model.ItemModel;
import com.cts.onlineordering.cartservice.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    @Autowired
    private ICartService cartService;

    @GetMapping("/cart/items")
    public ResponseEntity<CartModel> getCartItems()
    {
        return null;
    }

    @PostMapping("/cart/addItems")
    public ResponseEntity<Boolean> addCartItem(/*@RequestBody CartItem item*/)
    {
        //cartService.addProduct(item);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
    @PutMapping("/cart/quantityplus/{itemId}/quantity/{quantity}")
    public ResponseEntity<Boolean> addQuantity(@PathVariable Integer itemId,@PathVariable Integer quantity)
    {
        cartService.increaseQuantity(itemId,quantity);
        return new ResponseEntity<Boolean>(true,HttpStatus.OK);
    }

    @PutMapping("/cart/quantityminus/{itemId}/quantity/{quantity}")
    public ResponseEntity<Boolean> minusQuantity(@PathVariable Integer itemId,@PathVariable Integer quantity)
    {
        cartService.decreaseQuantity(itemId,quantity);
        return new ResponseEntity<Boolean>(true,HttpStatus.OK);
    }
    @DeleteMapping("/cart/{itemId}")
    public ResponseEntity<Boolean> deleteItem(@PathVariable Integer itemId)
    {
        cartService.deleteProduct(itemId);
        return new ResponseEntity<Boolean>(true,HttpStatus.OK);
    }
}
