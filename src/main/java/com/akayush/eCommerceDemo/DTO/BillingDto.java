package com.akayush.eCommerceDemo.DTO;

import lombok.Data;

@Data
public class BillingDto {
    private Long checkoutId;

    public Long getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(Long checkoutId) {
        this.checkoutId = checkoutId;
    }
}
