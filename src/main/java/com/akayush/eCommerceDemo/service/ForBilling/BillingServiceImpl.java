package com.akayush.eCommerceDemo.service.ForBilling;
import com.akayush.eCommerceDemo.DTO.BillingDto;
import com.akayush.eCommerceDemo.Model.Billing;
import com.akayush.eCommerceDemo.Model.Checkout;
import com.akayush.eCommerceDemo.Repository.BillingRepository;
import com.akayush.eCommerceDemo.Repository.CheckoutRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BillingServiceImpl implements BillingService {

    @Autowired
    private BillingRepository billingRepository;

    @Autowired
    private CheckoutRepository checkoutRepository;

    @Override
    @Transactional
    public Billing processPayment(BillingDto billingDto) {
        Long checkoutId = billingDto.getCheckoutId();

        Checkout checkout = checkoutRepository.findById(checkoutId).orElse(null);

        if (checkout == null) {
            return null;
        }

        Billing billing = new Billing();
        billing.setCheckout(checkout);
        double totalPrice = checkout.getTotalPrice();
        billing.setTotalAmount(totalPrice);
        String TransactionId = processPayment(billing);
        billing.setTransactionId(TransactionId);

        return billingRepository.save(billing);
    }

    public String processPayment(Billing billing) {
        String TransactionId = String.valueOf(System.currentTimeMillis());
        billing.setPaymentStatus("Success");

        return TransactionId;
    }
}

