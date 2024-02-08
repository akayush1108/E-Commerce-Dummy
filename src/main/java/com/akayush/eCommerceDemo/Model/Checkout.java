package com.akayush.eCommerceDemo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Checkout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "checkout", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CartItem> cartItems=new ArrayList<>();
    private double totalPrice;


//    @OneToOne(mappedBy = "checkout", cascade = CascadeType.ALL)
//    private Billing billing;

    // Additional checkout-related fields, e.g., totalAmount, shippingAddress, etc.

    // Constructors, getters, setters, and other methods



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

//    public Billing getBilling() {
//        return billing;
//    }
//
//    public void setBilling(Billing billing) {
//        this.billing = billing;
//    }
}

