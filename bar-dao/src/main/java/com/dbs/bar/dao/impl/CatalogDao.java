package com.dbs.bar.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.dbs.bar.dao.ICatalogDao;
import com.dbs.bar.dto.CatalogDto;
import com.dbs.bar.entity.Catalog;
import com.dbs.bar.repository.CatalogRepository;

@Repository
public class CatalogDao implements ICatalogDao {

	private static final Integer	DISABLE	= 0;

	@Resource
	private CatalogRepository		catalogRepository;

	@Override
	public void create(CatalogDto catalogDto) {
		catalogRepository.save(parseDtoToEntity(catalogDto));
	}

	@Override
	public void update(CatalogDto catalogDto) {
		catalogRepository.save(parseDtoToEntity(catalogDto));
	}

	@Override
	public void delete(CatalogDto catalogDto) {
		Catalog catalog = catalogRepository.findOne(catalogDto.getCatalogId());
		catalog.setState(DISABLE);
		catalogRepository.save(catalog);
	}

	@Override
	public List<CatalogDto> findAll() {
		List<Catalog> catalogs = catalogRepository.findAll();
		List<CatalogDto> catalogsDto = new ArrayList<>(0);
		for (Catalog catalog : catalogs) {
			catalogsDto.add(parseEntityToDto(catalog));
		}
		return catalogsDto;
	}

	private CatalogDto parseEntityToDto(Catalog catalog) {
		CatalogDto catalogDto = new CatalogDto();
		BeanUtils.copyProperties(catalog, catalogDto);
		return catalogDto;
	}

	private Catalog parseDtoToEntity(CatalogDto catalogDto) {
		Catalog catalog = new Catalog();
		BeanUtils.copyProperties(catalogDto, catalog);
		return catalog;
	}

}
