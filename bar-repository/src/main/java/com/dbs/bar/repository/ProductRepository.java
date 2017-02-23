package com.dbs.bar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.bar.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
