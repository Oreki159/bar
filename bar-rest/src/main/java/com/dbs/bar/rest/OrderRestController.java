package com.dbs.bar.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.bar.dto.OrderDto;
import com.dbs.bar.service.IOrderService;

@RestController
@RequestMapping(path = "/app/orders")
public class OrderRestController {

	@Autowired
	private IOrderService orderService;

	@RequestMapping(method = RequestMethod.POST)
	public void create(@RequestBody OrderDto orderDto) {
		orderService.create(orderDto);
	}
	
	@RequestMapping(path="/{id}")
	public OrderDto findById(@PathVariable Integer id){
		return orderService.findById(id);
	}
	
}
