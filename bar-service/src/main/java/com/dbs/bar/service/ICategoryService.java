package com.dbs.bar.service;

import java.util.List;

import com.dbs.bar.dto.CategoryDto;

/**
 * 
 * @author Jorge Luis Alvarez A.
 * @version 1.0.0
 *
 */
public interface ICategoryService {

	void create(CategoryDto categoryDto);

	void update(CategoryDto categoryDto);

	void delete(CategoryDto categoryDto);

	List<CategoryDto> findAll();

}
