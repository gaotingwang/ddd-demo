package com.gtw.business.infrastructure.db.repository;

import java.util.List;

import com.gtw.business.domain.aggregate.shop.Product;
import com.gtw.business.domain.aggregate.shop.ProductRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public List<Product> getShopProducts(String id) {
        return null;
    }
}
