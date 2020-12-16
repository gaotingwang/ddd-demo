package com.gtw.business.domain.aggregate.shop;

import java.util.List;

import com.gtw.business.common.model.Address;

public class Shop {
    private String id;
    private String name;
    private Address address;
    //private List<Product> products;

    private ShopRepository shopRepository;
    private ProductRepository productRepository;

    public Shop(ShopRepository shopRepository, ProductRepository productRepository, String shopId) {
        this.shopRepository = shopRepository;
        this.productRepository = productRepository;
        this.id = shopId;
    }

    public Shop(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public List<Product> getProducts(ProductRepository productRepository) {
        return productRepository.getShopProducts(this.id);
    }

    public void purchase(List<Product> products) {

    }
}
