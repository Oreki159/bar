package com.dbs.bar.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.bar.dto.ReputationDto;
import com.dbs.bar.service.IReputationService;

@RestController
@RequestMapping(path = "/app/reputation")
public class ReputationRestController {

	@Autowired
	private IReputationService reputationService;

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public void create(@RequestBody ReputationDto reputationDto) {
		reputationService.create(reputationDto);
	}

	@RequestMapping(path = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody ReputationDto reputationDto) {
		reputationService.update(reputationDto);
	}

	@RequestMapping(path = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestBody ReputationDto reputationDto) {
		reputationService.delete(reputationDto);
	}

	@RequestMapping(path = "/findAll", method = RequestMethod.GET)
	public List<ReputationDto> findAll() {
		return reputationService.findAll();
	}

}
