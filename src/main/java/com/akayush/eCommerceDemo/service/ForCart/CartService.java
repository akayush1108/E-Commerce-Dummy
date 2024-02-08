package com.akayush.eCommerceDemo.service.ForCart;

import com.akayush.eCommerceDemo.DTO.CartItemDto;
import com.akayush.eCommerceDemo.Model.CartItem;

import java.util.List;

public interface CartService {
    List<CartItem> getUserCartItems(Long userId);
    CartItem addCartItem(CartItemDto cartItemDto);

}
