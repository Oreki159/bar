package com.dbs.bar.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.dbs.bar.dao.IOrderDao;
import com.dbs.bar.dto.OrderDto;
import com.dbs.bar.entity.Order;
import com.dbs.bar.repository.OrderRepository;

@Repository
public class OrderDao implements IOrderDao {

	private static final Integer	DISABLE	= 0;

	@Resource
	private OrderRepository			orderRepository;

	@Override
	public OrderDto create(OrderDto orderDto) {
		return parseEntityToDto(orderRepository.save(parseDtoToEntity(orderDto)));
	}

	@Override
	public void update(OrderDto orderDto) {
		orderRepository.save(parseDtoToEntity(orderDto));
	}

	@Override
	public void delete(OrderDto orderDto) {
		Order order = orderRepository.findOne(orderDto.getOrderId());
		order.setState(DISABLE);
		orderRepository.save(order);
	}

	@Override
	public List<OrderDto> findAll() {
		List<Order> orders = orderRepository.findAll();
		List<OrderDto> ordersDto = new ArrayList<>(0);
		for (Order order : orders) {
			ordersDto.add(parseEntityToDto(order));
		}
		return ordersDto;
	}

	private OrderDto parseEntityToDto(Order order) {
		OrderDto orderDto = new OrderDto();
		BeanUtils.copyProperties(order, orderDto);
		return orderDto;
	}

	private Order parseDtoToEntity(OrderDto orderDto) {
		Order order = new Order();
		BeanUtils.copyProperties(orderDto, order);
		return order;
	}

}
