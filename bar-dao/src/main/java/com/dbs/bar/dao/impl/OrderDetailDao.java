package com.dbs.bar.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.dbs.bar.dao.IOrderDetailDao;
import com.dbs.bar.dto.OrderDetailDto;
import com.dbs.bar.entity.OrderDetail;
import com.dbs.bar.repository.OrderDetailRepository;

@Repository
public class OrderDetailDao implements IOrderDetailDao {

	@Resource
	private OrderDetailRepository orderDetailRepository;

	@Override
	public void create(OrderDetailDto orderDetailDto) {
		orderDetailRepository.save(parseDtoToEntity(orderDetailDto));
	}

	@Override
	public void update(OrderDetailDto orderDetailDto) {
		orderDetailRepository.save(parseDtoToEntity(orderDetailDto));
	}

	@Override
	public void delete(OrderDetailDto orderDetailDto) {
		orderDetailRepository.delete(orderDetailDto.getOrderDetailId());
	}

	@Override
	public List<OrderDetailDto> findByOrderId(Integer orderId) {
		return getOrderDetails(orderDetailRepository.findByOrderId(orderId));
	}

	@Override
	public List<OrderDetailDto> findAll() {
		return getOrderDetails(orderDetailRepository.findAll());
	}

	private List<OrderDetailDto> getOrderDetails(List<OrderDetail> orderDetails){
		List<OrderDetailDto> orderDetailsDto = new ArrayList<>(0);
		for (OrderDetail orderDetail : orderDetails) {
			orderDetailsDto.add(parseEntityToDto(orderDetail));
		}
		return orderDetailsDto;	
	}
	
	private OrderDetailDto parseEntityToDto(OrderDetail orderDetail) {
		OrderDetailDto orderDetailDto = new OrderDetailDto();
		BeanUtils.copyProperties(orderDetail, orderDetailDto);
		return orderDetailDto;
	}

	private OrderDetail parseDtoToEntity(OrderDetailDto orderDetailDto) {
		OrderDetail orderDetail = new OrderDetail();
		BeanUtils.copyProperties(orderDetailDto, orderDetail);
		return orderDetail;
	}

}
