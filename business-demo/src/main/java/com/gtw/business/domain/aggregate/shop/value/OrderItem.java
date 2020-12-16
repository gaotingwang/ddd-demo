package com.gtw.business.domain.aggregate.shop.value;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderItem {
    private String productId;
    private int count;
    private BigDecimal itemPrice;

    public static OrderItem create(String productId, int count, BigDecimal itemPrice) {
        return OrderItem.builder()
                .productId(productId)
                .count(count)
                .itemPrice(itemPrice)
                .build();
    }

    public BigDecimal totalPrice() {
        return itemPrice.multiply(BigDecimal.valueOf(count));
    }

    public void updateCount(int count) {
        this.count = count;
    }

    public String getProductId() {
        return productId;
    }

    public int getCount() {
        return count;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }
}
