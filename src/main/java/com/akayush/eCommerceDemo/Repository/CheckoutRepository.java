package com.akayush.eCommerceDemo.Repository;

import com.akayush.eCommerceDemo.Model.Checkout;
import com.akayush.eCommerceDemo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutRepository extends JpaRepository<Checkout, Long> {
    Checkout findByUser(User user);
    // You can add custom query methods if needed
}

