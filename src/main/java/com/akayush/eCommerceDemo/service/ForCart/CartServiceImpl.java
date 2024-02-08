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
        // Check if the user and product exist
        User user = userRepository.findById(cartItemDto.getUserId()).orElse(null);
        if (user == null) {
            // Handle the case where the user does not exist
            return null;
        }

        // Check if there's an existing cart item for the user and product
        CartItem existingCartItem = cartItemRepository.findByUserIdAndProductId(
                cartItemDto.getUserId(), cartItemDto.getProductId());

        if (existingCartItem != null) {
            // If it exists, update the quantity
            int newQuantity = existingCartItem.getQuantity() + cartItemDto.getQuantity();
            existingCartItem.setQuantity(newQuantity);
            return cartItemRepository.save(existingCartItem);
        } else {
            // If it doesn't exist, create a new CartItem
            CartItem cartItem = new CartItem();
            cartItem.setProduct(productRepository.getById(cartItemDto.getProductId()));
            cartItem.setQuantity(cartItemDto.getQuantity());
            cartItem.setUser(user);

            // Set the Checkout entity to null
            //cartItem.setCheckout(null);     // for checkout table set null value place of price till user not completed the checkout process


            // Create or retrieve the user's checkout
            List<Checkout> checkouts = user.getCheckouts();
            Checkout checkout;

            if (checkouts == null || checkouts.isEmpty()) {
                // If the user doesn't have any checkouts, create a new one
                checkout = new Checkout();
                checkout.setUser(user);
            } else {
                // If the user has existing checkouts, you might want to choose one (e.g., the latest one)
                // Here, we simply select the first one for demonstration purposes
                checkout = checkouts.get(0);
            }

// Add the cart item to the checkout
            cartItem.setCheckout(checkout); // Set the checkout for the cart item
            checkout.getCartItems().add(cartItem);

// Save the checkout and the cart item
            checkoutRepository.save(checkout);
            return cartItemRepository.save(cartItem);
        }
    }
}