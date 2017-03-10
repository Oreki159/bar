package com.dbs.bar.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.dbs.bar.dao.IProductDao;
import com.dbs.bar.dao.constant.DaoConstant;
import com.dbs.bar.dto.ProductDto;
import com.dbs.bar.entity.Product;
import com.dbs.bar.repository.ProductRepository;

/**
 * 
 * @author Jorge Luis Alvarez A.
 * @version 1.0.0
 *
 */
@Repository
public class ProductDao implements IProductDao {

	@Resource
	private ProductRepository		productRepository;

	@Override
	public void create(ProductDto productDto) {
		productDto.setState(DaoConstant.ENABLE);
		productRepository.save(parseDtoToEntity(productDto));
	}

	@Override
	public void update(ProductDto productDto) {
		productRepository.save(parseDtoToEntity(productDto));
	}

	@Override
	public void delete(ProductDto productDto) {
		Product product = productRepository.findOne(productDto.getProductId());
		product.setState(DaoConstant.DISABLE);
		productRepository.save(product);
	}

	@Override
	public ProductDto findById(Integer id) {
		return parseEntityToDto(productRepository.findOne(id));
	}
		
	@Override
	public List<ProductDto> findAll() {
		List<Product> products = productRepository.findAll();
		List<ProductDto> productsDto = new ArrayList<>(0);
		for (Product product : products) {
			productsDto.add(parseEntityToDto(product));
		}
		return productsDto;
	}

	private ProductDto parseEntityToDto(Product product) {
		ProductDto productDto = new ProductDto();
		BeanUtils.copyProperties(product, productDto);
		return productDto;
	}

	private Product parseDtoToEntity(ProductDto productDto) {
		Product product = new Product();
		BeanUtils.copyProperties(productDto, product);
		return product;
	}

}
