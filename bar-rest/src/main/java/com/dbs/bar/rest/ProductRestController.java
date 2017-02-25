package com.dbs.bar.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.bar.dto.ProductDto;
import com.dbs.bar.service.IProductService;

@RestController
@RequestMapping(path = "/app/product")
public class ProductRestController {

	@Autowired
	private IProductService productService;

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public void create(@RequestBody ProductDto productDto) {
		productService.create(productDto);
	}

	@RequestMapping(path = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody ProductDto productDto) {
		productService.update(productDto);
	}

	@RequestMapping(path = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestBody ProductDto productDto) {
		productService.delete(productDto);
	}

	@RequestMapping(path = "/findAll", method = RequestMethod.GET)
	public List<ProductDto> findAll() {
		return productService.findAll();
	}

}
