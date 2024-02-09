package com.akayush.eCommerceDemo.DTO;
import lombok.Data;
import java.util.Map;

@Data
public class CheckoutDto {
    private Long userId;
    private Map<Long,Integer> productQuantities;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Map<Long, Integer> getProductQuantities() {
        return productQuantities;
    }

    public void setProductQuantities(Map<Long, Integer> productQuantities) {
        this.productQuantities = productQuantities;
    }
}

