package com.dbs.bar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.bar.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
