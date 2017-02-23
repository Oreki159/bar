package com.dbs.bar.dao;

import java.util.List;

import com.dbs.bar.dto.CategoryDto;

public interface ICategoryDao {

	void create(CategoryDto categoryDto);

	void update(CategoryDto categoryDto);

	void delete(CategoryDto categoryDto);

	List<CategoryDto> findAll();

}
