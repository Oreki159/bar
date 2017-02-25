package com.dbs.bar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.bar.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

	List<OrderDetail> findByOrderId(Integer orderId);

}
