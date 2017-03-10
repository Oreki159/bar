package com.dbs.bar.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.dbs.bar.dao.IReputationDao;
import com.dbs.bar.dao.constant.DaoConstant;
import com.dbs.bar.dto.ReputationDto;
import com.dbs.bar.entity.Reputation;
import com.dbs.bar.repository.ReputationRepository;

@Repository
public class ReputationDao implements IReputationDao {

	@Resource
	private ReputationRepository	reputationRepository;

	@Override
	public void create(ReputationDto reputationDto) {
		reputationDto.setState(DaoConstant.ENABLE);
		reputationRepository.save(parseDtoToEntity(reputationDto));
	}

	@Override
	public void update(ReputationDto reputationDto) {
		reputationRepository.save(parseDtoToEntity(reputationDto));
	}

	@Override
	public void delete(ReputationDto reputationDto) {
		Reputation reputation = reputationRepository.findOne(reputationDto.getReputationId());
		reputation.setState(DaoConstant.DISABLE);
		reputationRepository.save(reputation);
	}

	@Override
	public List<ReputationDto> findAll() {
		List<Reputation> reputations = reputationRepository.findAll();
		List<ReputationDto> reputationsDto = new ArrayList<>(0);
		for (Reputation reputation : reputations) {
			reputationsDto.add(parseEntityToDto(reputation));
		}
		return reputationsDto;
	}

	private ReputationDto parseEntityToDto(Reputation reputation) {
		ReputationDto reputationDto = new ReputationDto();
		BeanUtils.copyProperties(reputation, reputationDto);
		return reputationDto;
	}

	private Reputation parseDtoToEntity(ReputationDto reputationDto) {
		Reputation reputation = new Reputation();
		BeanUtils.copyProperties(reputationDto, reputation);
		return reputation;
	}

}
