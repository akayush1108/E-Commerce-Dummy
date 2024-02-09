package com.akayush.eCommerceDemo.Controller;
import com.akayush.eCommerceDemo.DTO.CartItemDto;
import com.akayush.eCommerceDemo.Model.CartItem;
import com.akayush.eCommerceDemo.service.ForCart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart-items")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping
    public List<CartItem> getUserCartItems(@RequestParam Long userId) {
        return cartService.getUserCartItems(userId);
    }

    @PostMapping
    public CartItem addCartItem(@RequestBody CartItemDto cartItemDto) {
        return cartService.addCartItem(cartItemDto);
    }

}
