package com.dbs.bar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.bar.dao.IOrderDao;
import com.dbs.bar.dao.IOrderDetailDao;
import com.dbs.bar.dto.OrderDetailDto;
import com.dbs.bar.dto.OrderDto;
import com.dbs.bar.service.IOrderService;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private IOrderDao		orderDao;

	@Autowired
	private IOrderDetailDao	orderDetailDao;

	@Override
	public void create(OrderDto orderDto) {
		OrderDto order = orderDao.create(orderDto);
		for (OrderDetailDto orderDetailDto : orderDto.getOrderDetails()) {
			orderDetailDto.setOrderId(order.getOrderId());
			orderDetailDao.create(orderDetailDto);
		}

	}

}
