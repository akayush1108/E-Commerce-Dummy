package com.akayush.eCommerceDemo.service.ForOrderHistory;

import com.akayush.eCommerceDemo.DTO.BillingDto;
import com.akayush.eCommerceDemo.Model.Billing;
import com.akayush.eCommerceDemo.Model.OrderHistory;
import com.akayush.eCommerceDemo.Repository.OrderHistoryRepository;
import com.akayush.eCommerceDemo.service.ForBilling.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

    @Autowired
    private OrderHistoryRepository orderHistoryRepository;

    @Autowired
    private BillingService billingService;

    @Override
    public OrderHistory createOrderHistory(BillingDto billingDto) {
        // First, process the payment and retrieve the billing details
        Billing billing = billingService.processPayment(billingDto);

        // Then, create an order history entry using the billing details
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setBilling(billing);

        // Save the order history entry
        return orderHistoryRepository.save(orderHistory);
    }

    @Override
    public List<OrderHistory> getOrderHistory(Long userId) {
        // Implement logic to retrieve order history for a given user ID from the repository
        // Example:
        // return orderHistoryRepository.findByUserId(userId);
        return null; // Placeholder, replace with actual implementation
    }
}
