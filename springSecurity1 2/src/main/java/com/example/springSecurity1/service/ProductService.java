package com.example.springSecurity1.service;

import com.example.springSecurity1.DTO.Product;
import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProductService {
    List<Product>productList=null;
    @PostConstruct
    public void loadProductsFromDB() {
        productList = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= 100; i++) {
            Product product = Product.builder()
                    .productId(i)
                    .name("product " + i)
                    .qty(random.nextInt(10))
                    .price(random.nextInt(5000))
                    .build();
            productList.add(product);
        }
    }
    public List<Product> getProducts() {
        return productList;
    }
    public Product getProduct(int id) {
        return productList.stream()
                .filter(product -> product.getProductId() == id)
                .findAny()
                .orElseThrow(() -> new RuntimeException("product " + id + " not found"));
    }

}
