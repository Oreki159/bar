package com.dbs.bar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.bar.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

}
