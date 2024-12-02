package com.example.springSecurity1.controller;

import com.example.springSecurity1.DTO.Product;
import com.example.springSecurity1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class ProductController {
    @Autowired
    private ProductService service;
    @GetMapping("/welcome")
    public String welcome(){
        return "it is not Secure";
    }
    @GetMapping("/all")
    public List<Product>getAllTheProducts(){
        return service.getProducts();
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id){
        return service.getProduct(id);
    }

}
