package com.akayush.eCommerceDemo.Controller;

import com.akayush.eCommerceDemo.DTO.BillingDto;
import com.akayush.eCommerceDemo.Model.OrderHistory;
import com.akayush.eCommerceDemo.service.ForOrderHistory.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-history")
public class OrderHistoryController {

    @Autowired
    private OrderHistoryService orderHistoryService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderHistory>> getOrderHistory(@PathVariable Long userId) {
        List<OrderHistory> orderHistory = orderHistoryService.getOrderHistory(userId);
        return ResponseEntity.ok(orderHistory);
    }

    @PostMapping("/create")
    public ResponseEntity<OrderHistory> createOrderHistory(@RequestBody BillingDto billingDto) {
        OrderHistory createdOrderHistory = orderHistoryService.createOrderHistory(billingDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderHistory);
    }
}
