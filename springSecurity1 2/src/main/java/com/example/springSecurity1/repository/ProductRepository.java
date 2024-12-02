package com.example.springSecurity1.repository;

import com.example.springSecurity1.DTO.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
