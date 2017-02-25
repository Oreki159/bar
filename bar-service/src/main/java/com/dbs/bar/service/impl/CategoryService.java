package com.dbs.bar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.bar.dao.ICategoryDao;
import com.dbs.bar.dto.CategoryDto;
import com.dbs.bar.service.ICategoryService;

/**
 * 
 * @author Jorge Luis Alvarez A.
 * @version 1.0.0
 *
 */
@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private ICategoryDao categoryDao;

	@Override
	public void create(CategoryDto categoryDto) {
		categoryDao.create(categoryDto);
	}

	@Override
	public void update(CategoryDto categoryDto) {
		categoryDao.update(categoryDto);
	}

	@Override
	public void delete(CategoryDto categoryDto) {
		categoryDao.delete(categoryDto);
	}

	@Override
	public List<CategoryDto> findAll() {
		return categoryDao.findAll();
	}

}
