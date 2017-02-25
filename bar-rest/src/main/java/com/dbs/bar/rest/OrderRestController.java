package com.dbs.bar.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.bar.dto.OrderDto;
import com.dbs.bar.service.IOrderService;

@RestController
@RequestMapping(path = "/app/order")
public class OrderRestController {

	@Autowired
	private IOrderService orderService;

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public void create(@RequestBody OrderDto orderDto) {
		orderService.create(orderDto);
	}

}
