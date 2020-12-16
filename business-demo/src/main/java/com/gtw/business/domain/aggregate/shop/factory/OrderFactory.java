package com.gtw.business.domain.aggregate.shop.factory;

import java.util.List;

import com.gtw.business.common.model.Address;
import com.gtw.business.domain.aggregate.shop.Order;
import com.gtw.business.domain.aggregate.shop.value.OrderIdGenerator;
import com.gtw.business.domain.aggregate.shop.value.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderFactory {
    private final OrderIdGenerator idGenerator;

    public OrderFactory(OrderIdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public Order create(List<OrderItem> items, Address address) {
        String orderId = idGenerator.generate();
        return Order.create(orderId, items, address);
    }
}
