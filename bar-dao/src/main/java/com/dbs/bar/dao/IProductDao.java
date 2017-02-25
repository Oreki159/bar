package com.dbs.bar.dao;

import java.util.List;

import com.dbs.bar.dto.ProductDto;


/**
 * 
 * @author Jorge Luis Alvarez A.
 * @version 1.0.0
 *
 */
public interface IProductDao {

	void create(ProductDto productDto);

	void update(ProductDto productDto);

	void delete(ProductDto productDto);

	ProductDto findById(Integer id);

	List<ProductDto> findAll();

}
