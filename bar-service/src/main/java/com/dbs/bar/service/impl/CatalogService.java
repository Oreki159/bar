package com.dbs.bar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.bar.dao.ICatalogDao;
import com.dbs.bar.dto.CatalogDto;
import com.dbs.bar.service.ICatalogService;

@Service
public class CatalogService implements ICatalogService {

	@Autowired
	private ICatalogDao catalogDao;

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
	public List<CatalogDto> findByBar(CatalogDto catalogDto) {
		return catalogDao.findByBar(catalogDto);
	}

	@Override
	public List<CatalogDto> findAll() {
		return catalogDao.findAll();
	}

}
