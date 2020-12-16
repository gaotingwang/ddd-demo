package com.gtw.business.service.query.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import com.gtw.business.common.model.Address;
import com.gtw.business.domain.aggregate.shop.Order;
import com.gtw.business.domain.aggregate.shop.value.OrderItem;
import lombok.Value;

@Value
public class OrderDTO {

    private String id;
    private List<OrderItem> items;
    private BigDecimal totalPrice;
    private String status;
    private Address address;
    private Instant createdAt;

    public static OrderDTO trans(Order order) {
        return new OrderDTO(order.getId(),
            order.getItems(),
            order.getTotalPrice(),
            order.getStatus().name(),
            order.getAddress(),
            order.getCreatedAt());
    }
}
