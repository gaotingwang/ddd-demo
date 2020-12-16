package com.gtw.business.domain.aggregate.shop.factory;

import com.gtw.business.common.model.Address;
import com.gtw.business.domain.aggregate.shop.ProductRepository;
import com.gtw.business.domain.aggregate.shop.ShopRepository;
import com.gtw.business.domain.aggregate.shop.Shop;
import org.springframework.stereotype.Component;

@Component
public class ShopFactory {
    private final ShopRepository shopRepository;
    private final ProductRepository productRepository;

    public ShopFactory(ShopRepository shopRepository, ProductRepository productRepository) {
        this.shopRepository = shopRepository;
        this.productRepository = productRepository;
    }

    public Shop load(String shopId) {
        // 为实体对象注入系统的singleton对象
        Shop shop = new Shop(shopRepository, productRepository, shopId);
        return shop;
    }

    public Shop create(String name, Address address) {
        // 为实体对象注入系统的singleton对象
        //Shop shop = new Shop(name, address);
        //shop.
        return null;
    }
}
