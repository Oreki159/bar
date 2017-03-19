package com.dbs.bar.dao.impl;

import static java.time.Instant.ofEpochMilli;
import static java.time.LocalDateTime.ofInstant;
import static java.time.ZoneId.systemDefault;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.dbs.bar.dao.ICatalogDao;
import com.dbs.bar.dao.constant.DaoConstant;
import com.dbs.bar.dto.CatalogDto;
import com.dbs.bar.entity.Catalog;
import com.dbs.bar.repository.CatalogRepository;

/**
 * 
 * @author Jorge Luis Alvarez A.
 * @version 1.0.0
 *
 */
@Repository
public class CatalogDao implements ICatalogDao {

	@Resource
	private CatalogRepository		catalogRepository;

	@Override
	public void create(CatalogDto catalogDto) {
		catalogDto.setState(DaoConstant.ENABLE);
		catalogRepository.save(parseDtoToEntity(catalogDto));
	}

	@Override
	public void update(CatalogDto catalogDto) {
		catalogRepository.save(parseDtoToEntity(catalogDto));
	}

	@Override
	public void delete(CatalogDto catalogDto) {
		Catalog catalog = catalogRepository.findOne(catalogDto.getCatalogId());
		catalog.setState(DaoConstant.DISABLE);
		catalogRepository.save(catalog);
	}

	@Override
	public List<CatalogDto> findByBarId(Integer barId) {
		return getCatalogs(catalogRepository.findByBarId(barId));
	}

	@Override
	public List<CatalogDto> findAll() {
		return getCatalogs(catalogRepository.findAll());
	}

	private List<CatalogDto> getCatalogs(List<Catalog> catalogs) {
		List<CatalogDto> catalogsDto = new ArrayList<>(0);
		for (Catalog catalog : catalogs) {
			catalogsDto.add(parseEntityToDto(catalog));
		}
		return catalogsDto;
	}

	private CatalogDto parseEntityToDto(Catalog catalog) {
		CatalogDto catalogDto = new CatalogDto();
		BeanUtils.copyProperties(catalog, catalogDto);

		catalogDto.setStartDate(catalog.getStartDate() == null ? null : ofInstant(ofEpochMilli(catalog.getStartDate().getTime()), systemDefault()).toLocalDate());
		catalogDto.setFinalDate(catalog.getFinalDate() == null ? null : ofInstant(ofEpochMilli(catalog.getFinalDate().getTime()), systemDefault()).toLocalDate());
		return catalogDto;
	}

	private Catalog parseDtoToEntity(CatalogDto catalogDto) {
		Catalog catalog = new Catalog();
		BeanUtils.copyProperties(catalogDto, catalog);
		catalog.setStartDate(catalogDto.getStartDate() == null ? null : Date.from(catalogDto.getStartDate().atStartOfDay(systemDefault()).toInstant()));
		catalog.setFinalDate(catalogDto.getFinalDate() == null ? null : Date.from(catalogDto.getFinalDate().atStartOfDay(systemDefault()).toInstant()));

		return catalog;
	}
}
