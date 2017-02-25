package com.dbs.bar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.bar.dao.IProductDao;
import com.dbs.bar.dto.ProductDto;
import com.dbs.bar.service.IProductService;

/**
 * 
 * @author Jorge Luis Alvarez A.
 * @version 1.0.0
 *
 */
@Service
public class ProductService implements IProductService {

	@Autowired
	private IProductDao productDao;

	@Override
	public void create(ProductDto productDto) {
		productDao.create(productDto);
	}

	@Override
	public void update(ProductDto productDto) {
		productDao.update(productDto);
	}

	@Override
	public void delete(ProductDto productDto) {
		productDao.delete(productDto);
	}

	@Override
	public ProductDto findById(Integer id) {
		return productDao.findById(id);
	}

	@Override
	public List<ProductDto> findAll() {
		return productDao.findAll();
	}

}
