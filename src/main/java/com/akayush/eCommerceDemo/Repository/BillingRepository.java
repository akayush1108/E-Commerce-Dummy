package com.akayush.eCommerceDemo.Repository;

import com.akayush.eCommerceDemo.Model.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

// BillingRepository.java
public interface BillingRepository extends JpaRepository<Billing, Long> {
    // Custom query methods if needed
}

