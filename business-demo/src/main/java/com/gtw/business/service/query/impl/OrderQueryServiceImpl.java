package com.gtw.business.service.query.impl;

import com.gtw.business.domain.aggregate.shop.Order;
import com.gtw.business.domain.aggregate.shop.OrderRepository;
import com.gtw.business.service.query.OrderQueryService;
import com.gtw.business.service.query.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * CQRS
 */
@Slf4j
@Component
public class OrderQueryServiceImpl implements OrderQueryService {

    private final OrderRepository orderRepository;

    public OrderQueryServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * 这里为了说明CQRS对查询的使用
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public OrderDTO byId(String id) {
        Order order = orderRepository.byId(id);
        return OrderDTO.trans(order);
    }

}
