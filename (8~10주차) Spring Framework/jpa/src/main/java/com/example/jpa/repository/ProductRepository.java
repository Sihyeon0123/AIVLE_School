package com.example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}