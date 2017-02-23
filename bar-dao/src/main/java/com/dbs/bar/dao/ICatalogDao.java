package com.dbs.bar.dao;

import java.util.List;

import com.dbs.bar.dto.CatalogDto;

public interface ICatalogDao {

	void create(CatalogDto catalogDto);

	void update(CatalogDto catalogDto);

	void delete(CatalogDto catalogDto);

	List<CatalogDto> findAll();

}
