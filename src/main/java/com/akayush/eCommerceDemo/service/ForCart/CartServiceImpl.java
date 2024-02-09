package com.akayush.eCommerceDemo.service.ForCart;
import com.akayush.eCommerceDemo.DTO.CartItemDto;
import com.akayush.eCommerceDemo.Model.CartItem;
import com.akayush.eCommerceDemo.Model.Checkout;
import com.akayush.eCommerceDemo.Model.User;
import com.akayush.eCommerceDemo.Repository.CartItemRepository;
import com.akayush.eCommerceDemo.Repository.CheckoutRepository;
import com.akayush.eCommerceDemo.Repository.ProductRepository;
import com.akayush.eCommerceDemo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CheckoutRepository checkoutRepository;

    @Override
    public List<CartItem> getUserCartItems(Long userId) {
        return cartItemRepository.findByUserId(userId);
    }

    @Override
    public CartItem addCartItem(CartItemDto cartItemDto) {
        User user = userRepository.findById(cartItemDto.getUserId()).orElse(null);
        if (user == null) {
            return null;
        }
        CartItem existingCartItem = cartItemRepository.findByUserIdAndProductId(
                cartItemDto.getUserId(), cartItemDto.getProductId());

        if (existingCartItem != null) {
            int newQuantity = existingCartItem.getQuantity() + cartItemDto.getQuantity();
            existingCartItem.setQuantity(newQuantity);
            return cartItemRepository.save(existingCartItem);
        } else {
            CartItem cartItem = new CartItem();
            cartItem.setProduct(productRepository.getById(cartItemDto.getProductId()));
            cartItem.setQuantity(cartItemDto.getQuantity());
            cartItem.setUser(user);

            List<Checkout> checkouts = user.getCheckouts();
            Checkout checkout;

            if (checkouts == null || checkouts.isEmpty()) {
                checkout = new Checkout();
                checkout.setUser(user);
            } else {
                checkout = checkouts.get(0);
            }

            cartItem.setCheckout(checkout);
            checkout.getCartItems().add(cartItem);

            checkoutRepository.save(checkout);
            return cartItemRepository.save(cartItem);
        }
    }
}