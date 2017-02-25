package com.dbs.bar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.bar.dao.ICatalogDao;
import com.dbs.bar.dto.CatalogDto;
import com.dbs.bar.service.ICatalogService;
import com.dbs.bar.service.IProductService;

/**
 * 
 * @author Jorge Luis Alvarez A.
 * @version 1.0.0
 *
 */
@Service
public class CatalogService implements ICatalogService {

	@Autowired
	private ICatalogDao		catalogDao;

	@Autowired
	private IProductService	productService;

	@Override
	public void create(CatalogDto catalogDto) {
		catalogDao.create(catalogDto);
	}

	@Override
	public void update(CatalogDto catalogDto) {
		catalogDao.update(catalogDto);
	}

	@Override
	public void delete(CatalogDto catalogDto) {
		catalogDao.delete(catalogDto);
	}

	@Override
	public List<CatalogDto> findByBarId(Integer barId) {
		List<CatalogDto> catalogs = catalogDao.findByBarId(barId);
		setProductInCatalogs(catalogs);
		return catalogs;
	}

	@Override
	public List<CatalogDto> findAll() {
		List<CatalogDto> catalogs = catalogDao.findAll();
		setProductInCatalogs(catalogs);
		return catalogs;
	}

	private void setProductInCatalogs(List<CatalogDto> catalogs) {
		for (CatalogDto catalog : catalogs) {
			catalog.setProduct(productService.findById(catalog.getProductId()));
		}
	}

}
