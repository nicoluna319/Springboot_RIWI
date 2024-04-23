package com.riwi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.entities.Product;

public interface ProductRepository extends JpaRepository <Product, Long> {
    public Product findByName (String Name);
    
}



