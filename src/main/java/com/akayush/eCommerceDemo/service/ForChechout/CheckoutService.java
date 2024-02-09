package com.akayush.eCommerceDemo.service.ForChechout;
import com.akayush.eCommerceDemo.DTO.CheckoutDto;
import com.akayush.eCommerceDemo.Model.Checkout;

public interface CheckoutService {
    Checkout processCheckout(CheckoutDto checkoutDto);
}


