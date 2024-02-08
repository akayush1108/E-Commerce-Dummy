package com.akayush.eCommerceDemo.DTO;

import lombok.Data;

// BillingDto.java
@Data
public class BillingDto {
    //    private List<Long> productIds; // Assuming a list of product IDs for billing
//    private double totalAmount;
    private Long checkoutId;

    public Long getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(Long checkoutId) {
        this.checkoutId = checkoutId;
    }
}
