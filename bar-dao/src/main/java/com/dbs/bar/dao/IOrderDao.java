package com.dbs.bar.dao;

import java.util.List;

import com.dbs.bar.dto.OrderDto;

public interface IOrderDao {

	void create(OrderDto orderDto);

	void update(OrderDto orderDto);

	void delete(OrderDto orderDto);

	List<OrderDto> findAll();

}
