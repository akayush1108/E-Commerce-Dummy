package com.akayush.eCommerceDemo.service.ForBilling;

import com.akayush.eCommerceDemo.DTO.BillingDto;
import com.akayush.eCommerceDemo.Model.Billing;
import com.akayush.eCommerceDemo.Model.Checkout;
import com.akayush.eCommerceDemo.PaymentStatus;
import com.akayush.eCommerceDemo.Repository.BillingRepository;
import com.akayush.eCommerceDemo.Repository.CheckoutRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// BillingServiceImpl.java
// Import statements...

@Service
public class BillingServiceImpl implements BillingService {

    @Autowired
    private BillingRepository billingRepository;

    @Autowired
    private CheckoutRepository checkoutRepository;

    @Override
    @Transactional
    public Billing processPayment(BillingDto billingDto) {
        Long checkoutId = billingDto.getCheckoutId();

        // Fetch checkout by checkoutId
        Checkout checkout = checkoutRepository.findById(checkoutId).orElse(null);

        if (checkout == null) {
            // Handle the case where checkout is not found
            // You may throw an exception or return an appropriate response
            return null;
        }

        Billing billing = new Billing();
        billing.setCheckout(checkout);

        // Retrieve the total price from the Checkout entity
        double totalPrice = checkout.getTotalPrice();
        billing.setTotalAmount(totalPrice);

        // Perform actual payment processing and get a real transaction ID
        String TransactionId = processPayment(billing);

        // Set the real transaction ID
        billing.setTransactionId(TransactionId);

        // Save the billing record
        return billingRepository.save(billing);
    }

    public String processPayment(Billing billing) {
        // Integrate with a payment gateway or service to perform the actual payment
        // Obtain a real transaction ID from the payment service
        // Example: String realTransactionId = paymentGateway.processPayment(billing);

        // For demonstration purposes, let's generate a fake transaction ID
        String TransactionId = String.valueOf(System.currentTimeMillis());

        billing.setPaymentStatus("Success");

        return TransactionId;
    }
}

