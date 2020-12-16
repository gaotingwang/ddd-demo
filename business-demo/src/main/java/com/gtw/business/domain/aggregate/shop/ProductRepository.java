package com.gtw.business.domain.aggregate.shop;

import java.util.List;

public interface ProductRepository {

    List<Product> getShopProducts(String id);
}
