package com.dbs.bar.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.dbs.bar.dao.ICategoryDao;
import com.dbs.bar.dto.CategoryDto;
import com.dbs.bar.entity.Category;
import com.dbs.bar.repository.CategoryRepository;

@Repository
public class CategoryDao implements ICategoryDao {

	@Resource
	private CategoryRepository categoryRepository;

	@Override
	public void create(CategoryDto categoryDto) {
		categoryRepository.save(parseDtoToEntity(categoryDto));
	}

	@Override
	public void update(CategoryDto categoryDto) {
		categoryRepository.save(parseDtoToEntity(categoryDto));
	}

	@Override
	public void delete(CategoryDto categoryDto) {
		categoryRepository.delete(parseDtoToEntity(categoryDto));
	}

	@Override
	public List<CategoryDto> findAll() {
		List<Category> categories = categoryRepository.findAll();
		List<CategoryDto> categoriesDto = new ArrayList<>(0);
		for (Category category : categories) {
			categoriesDto.add(parseEntityToDto(category));
		}
		return categoriesDto;
	}

	private CategoryDto parseEntityToDto(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		BeanUtils.copyProperties(category, categoryDto);
		return categoryDto;
	}

	private Category parseDtoToEntity(CategoryDto categoryDto) {
		Category category = new Category();
		BeanUtils.copyProperties(categoryDto, category);
		return category;
	}

}
