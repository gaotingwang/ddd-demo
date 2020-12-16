package com.gtw.business.service.command.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.gtw.business.domain.aggregate.shop.Order;
import com.gtw.business.domain.aggregate.shop.OrderRepository;
import com.gtw.business.domain.aggregate.shop.factory.OrderFactory;
import com.gtw.business.domain.aggregate.shop.value.OrderItem;
import com.gtw.business.service.command.OrderCommandService;
import com.gtw.business.service.command.cmd.CreateOrderCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务逻辑层，很薄的一层，实际业务功能是在domain中实现的
 */
@Service
@Slf4j
public class OrderCommandServiceImpl implements OrderCommandService {
    @Autowired(required = false)
    private OrderFactory orderFactory;
    @Autowired(required = false)
    private OrderRepository orderRepository;

    /**
     * 事务是在业务逻辑层进行控制的
     * @param command
     * @return
     */
    @Transactional
    @Override
    public String createOrder(CreateOrderCommand command) {
        List<OrderItem> items = command.getItems().stream()
            .map(item -> OrderItem.create(item.getProductId(),
                item.getCount(),
                item.getItemPrice()))
            .collect(Collectors.toList());

        Order order = orderFactory.create(items, command.getAddress());
        orderRepository.save(order);
        log.info("Created order[{}].", order.getId());
        return order.getId();
    }
}
