package com.akayush.eCommerceDemo.Controller;

import com.akayush.eCommerceDemo.DTO.CheckoutDto;
import com.akayush.eCommerceDemo.Model.Checkout;
import com.akayush.eCommerceDemo.service.ForChechout.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    @PostMapping
    public Checkout processCheckout(@RequestBody CheckoutDto checkoutDto) {
        return checkoutService.processCheckout(checkoutDto);
    }
}
