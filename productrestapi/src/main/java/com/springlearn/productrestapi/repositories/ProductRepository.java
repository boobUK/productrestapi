package com.springlearn.productrestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springlearn.productrestapi.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
