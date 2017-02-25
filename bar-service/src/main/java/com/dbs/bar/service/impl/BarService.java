package com.dbs.bar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.bar.dao.IBarDao;
import com.dbs.bar.dto.BarDto;
import com.dbs.bar.service.IBarService;

/**
 * 
 * @author Jorge Luis Alvarez A.
 * @version 1.0.0
 *
 */
@Service
public class BarService implements IBarService {

	@Autowired
	private IBarDao barDao;

	@Override
	public void create(BarDto barDto) {
		barDao.create(barDto);
	}

	@Override
	public void update(BarDto barDto) {
		barDao.update(barDto);
	}

	@Override
	public void delete(BarDto barDto) {
		barDao.delete(barDto);
	}

	@Override
	public List<BarDto> findAll() {
		return barDao.findAll();
	}

}
