package com.akayush.eCommerceDemo.service.ForBilling;

import com.akayush.eCommerceDemo.DTO.BillingDto;
import com.akayush.eCommerceDemo.Model.Billing;

// BillingService.java
public interface BillingService {
    Billing processPayment(BillingDto billingDto);
    //void processDummyPayment(Billing billing);
}

