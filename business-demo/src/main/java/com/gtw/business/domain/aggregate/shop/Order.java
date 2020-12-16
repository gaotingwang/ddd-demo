package com.gtw.business.domain.aggregate.shop;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import com.gtw.business.common.model.Address;
import com.gtw.business.domain.aggregate.shop.value.OrderItem;
import lombok.Builder;
import lombok.Getter;

import static java.math.BigDecimal.ZERO;
import static java.time.Instant.now;

@Getter
@Builder
public class Order {
    private String id;
    private List<OrderItem> items;
    private BigDecimal totalPrice;
    private OrderStatus status;
    private Address address;
    private Instant createdAt;

    public static Order create(String id, List<OrderItem> items, Address address) {
        Order order = Order.builder()
                .id(id)
                .items(items)
                .totalPrice(calculateTotalPrice(items))
                .status(OrderStatus.CREATED)
                .address(address)
                .createdAt(now())
                .build();
        // todo 发布事件 order.raiseCreatedEvent(id, items, address);
        return order;
    }

    private static BigDecimal calculateTotalPrice(List<OrderItem> items) {
        return items.stream()
            .map(OrderItem::totalPrice)
            .reduce(ZERO, BigDecimal::add);
    }

    public enum OrderStatus {
        CREATED,
        PAID
    }

}
