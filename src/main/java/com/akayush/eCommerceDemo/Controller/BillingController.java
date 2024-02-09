package com.akayush.eCommerceDemo.Controller;
import com.akayush.eCommerceDemo.DTO.BillingDto;
import com.akayush.eCommerceDemo.Model.Billing;
import com.akayush.eCommerceDemo.service.ForBilling.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/billing")
public class BillingController {
    @Autowired
    private BillingService billingService;
    @PostMapping("/process-payment")
    public Billing processPayment(@RequestBody BillingDto billingDto)
    {
        return billingService.processPayment(billingDto);
    }
}


