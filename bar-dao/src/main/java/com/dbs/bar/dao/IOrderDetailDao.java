package com.dbs.bar.dao;

import java.util.List;

import com.dbs.bar.dto.OrderDetailDto;

public interface IOrderDetailDao {

	void create(OrderDetailDto orderDetailDto);

	void update(OrderDetailDto orderDetailDto);

	void delete(OrderDetailDto orderDetailDto);

	List<OrderDetailDto> findAll();

}
