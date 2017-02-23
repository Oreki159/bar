package com.dbs.bar.dao;

import java.util.List;

import com.dbs.bar.dto.ReputationDto;

public interface IReputationDao {

	void create(ReputationDto reputationDto);

	void update(ReputationDto reputationDto);

	void delete(ReputationDto reputationDto);

	List<ReputationDto> findAll();

}
