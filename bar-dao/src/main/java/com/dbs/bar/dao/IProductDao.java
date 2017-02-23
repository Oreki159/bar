package com.dbs.bar.dao;

import java.util.List;

import com.dbs.bar.dto.ProductDto;

public interface IProductDao {

	void create(ProductDto productDto);

	void update(ProductDto productDto);

	void delete(ProductDto productDto);

	List<ProductDto> findAll();

}
