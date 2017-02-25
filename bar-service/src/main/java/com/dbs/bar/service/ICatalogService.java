package com.dbs.bar.service;

import java.util.List;

import com.dbs.bar.dto.CatalogDto;

public interface ICatalogService {

	void create(CatalogDto catalogDto);

	void update(CatalogDto catalogDto);

	void delete(CatalogDto catalogDto);

	List<CatalogDto> findByBar(CatalogDto catalogDto);

	List<CatalogDto> findAll();

}
