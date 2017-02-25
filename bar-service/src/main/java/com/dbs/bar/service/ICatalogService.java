package com.dbs.bar.service;

import java.util.List;

import com.dbs.bar.dto.CatalogDto;

/**
 * 
 * @author Jorge Luis Alvarez A.
 * @version 1.0.0
 *
 */
public interface ICatalogService {

	void create(CatalogDto catalogDto);

	void update(CatalogDto catalogDto);

	void delete(CatalogDto catalogDto);

	List<CatalogDto> findByBarId(Integer barId);

	List<CatalogDto> findAll();

}
