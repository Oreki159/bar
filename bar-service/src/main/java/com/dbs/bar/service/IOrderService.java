package com.dbs.bar.service;

import com.dbs.bar.dto.OrderDto;

/**
 * 
 * @author Jorge Luis Alvarez A.
 * @version 1.0.0
 *
 */
public interface IOrderService {

	void create(OrderDto orderDto);

	OrderDto findById(Integer id);

}
