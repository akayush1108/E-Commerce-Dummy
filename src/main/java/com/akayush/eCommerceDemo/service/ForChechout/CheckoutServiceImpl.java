package com.akayush.eCommerceDemo.service.ForChechout;

import com.akayush.eCommerceDemo.DTO.CheckoutDto;
import com.akayush.eCommerceDemo.Model.CartItem;
import com.akayush.eCommerceDemo.Model.Checkout;
import com.akayush.eCommerceDemo.Model.Product;
import com.akayush.eCommerceDemo.Model.User;
import com.akayush.eCommerceDemo.Repository.CartItemRepository;
import com.akayush.eCommerceDemo.Repository.CheckoutRepository;
import com.akayush.eCommerceDemo.Repository.ProductRepository;
import com.akayush.eCommerceDemo.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CheckoutRepository checkoutRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Checkout processCheckout(CheckoutDto checkoutDto) {
        Long userId = checkoutDto.getUserId();
        User user = userRepository.findById(userId).orElse(null);

        if (user != null) {
            Checkout existingCheckout = checkoutRepository.findByUser(user);

            if (existingCheckout != null) {
                List<CartItem> cartItems = cartItemRepository.findByUserId(userId);
                existingCheckout.getCartItems().clear(); // Remove existing cart items
                existingCheckout.getCartItems().addAll(cartItems);
                double totalPrice = calculateTotalPrice(cartItems);
                existingCheckout.setTotalPrice(totalPrice);

                return checkoutRepository.save(existingCheckout);
            }
            else {
                Checkout newCheckout = new Checkout();
                newCheckout.setUser(user);

                List<CartItem> cartItems = cartItemRepository.findByUserId(userId);
                for (CartItem cartItem : cartItems) {
                    cartItem.setCheckout(newCheckout);
                }

                newCheckout.setCartItems(cartItems);
                double totalPrice = calculateTotalPrice(cartItems);
                newCheckout.setTotalPrice(totalPrice);

                return checkoutRepository.save(newCheckout);
            }
        }
        else {
            return null;
        }
    }

    private double calculateTotalPrice(List<CartItem> cartItems) {
        double totalPrice = 0;

        for(CartItem cartItem: cartItems){
            Product product = cartItem.getProduct();
            int quantity = cartItem.getQuantity();

            if (product != null) {
                totalPrice += product.getPrice() * quantity;
            }
        }

        return totalPrice;
    }
}