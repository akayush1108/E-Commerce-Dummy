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
        Billing billing = billingService.processPayment(billingDto);

        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setBilling(billing);
        return orderHistoryRepository.save(orderHistory);
    }

    @Override
    public List<OrderHistory> getOrderHistory(Long userId) {
        return null;
    }
}
