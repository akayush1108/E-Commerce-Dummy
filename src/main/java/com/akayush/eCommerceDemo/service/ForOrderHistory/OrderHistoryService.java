package com.akayush.eCommerceDemo.service.ForOrderHistory;
import com.akayush.eCommerceDemo.DTO.BillingDto;
import com.akayush.eCommerceDemo.Model.OrderHistory;

import java.util.List;

public interface OrderHistoryService {
    OrderHistory createOrderHistory(BillingDto billingDto);

    List<OrderHistory> getOrderHistory(Long userId);
}
