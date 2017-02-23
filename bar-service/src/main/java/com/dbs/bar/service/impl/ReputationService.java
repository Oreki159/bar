package com.dbs.bar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.bar.dao.IReputationDao;
import com.dbs.bar.dto.ReputationDto;
import com.dbs.bar.service.IReputationService;

@Service
public class ReputationService implements IReputationService {

	@Autowired
	private IReputationDao reputationDao;

	@Override
	public void create(ReputationDto reputationDto) {
		reputationDao.create(reputationDto);
	}

	@Override
	public void update(ReputationDto reputationDto) {
		reputationDao.update(reputationDto);
	}

	@Override
	public void delete(ReputationDto reputationDto) {
		reputationDao.delete(reputationDto);
	}

	@Override
	public List<ReputationDto> findAll() {
		return reputationDao.findAll();
	}

}
