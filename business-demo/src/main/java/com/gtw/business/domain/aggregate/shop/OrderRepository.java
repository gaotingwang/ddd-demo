package com.gtw.business.domain.aggregate.shop;

public interface OrderRepository {
    void save(Order order);
    Order byId(String id);
}
