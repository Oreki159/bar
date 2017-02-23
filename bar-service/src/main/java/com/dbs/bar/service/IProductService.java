package com.dbs.bar.service;

import java.util.List;

import com.dbs.bar.dto.ProductDto;

public interface IProductService {

	void create(ProductDto productDto);

	void update(ProductDto productDto);

	void delete(ProductDto productDto);

	List<ProductDto> findAll();

}
