package com.dbs.bar.service;

import java.util.List;

import com.dbs.bar.dto.ReputationDto;

public interface IReputationService {

	void create(ReputationDto reputationDto);

	void update(ReputationDto reputationDto);

	void delete(ReputationDto reputationDto);

	List<ReputationDto> findAll();

}
