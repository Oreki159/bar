package com.dbs.bar.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.bar.dto.CategoryDto;
import com.dbs.bar.service.ICategoryService;

@RestController
@RequestMapping(path = "/app/categories")
public class CategoryRestController {

	@Autowired
	private ICategoryService categoryService;

	@RequestMapping(method = RequestMethod.POST)
	public void create(@RequestBody CategoryDto categoryDto) {
		categoryService.create(categoryDto);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody CategoryDto categoryDto) {
		categoryService.update(categoryDto);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@RequestBody CategoryDto categoryDto) {
		categoryService.delete(categoryDto);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<CategoryDto> findAll() {
		return categoryService.findAll();
	}

}
