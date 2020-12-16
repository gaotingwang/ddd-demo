package com.gtw.business.infrastructure.db.repository;

import com.gtw.business.domain.aggregate.shop.Order;
import com.gtw.business.domain.aggregate.shop.OrderRepository;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    @Override
    public void save(Order order) {

    }

    @Override
    public Order byId(String id) {
        return null;
    }
}
