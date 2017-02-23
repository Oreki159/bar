package com.dbs.bar.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.bar.dto.BarDto;
import com.dbs.bar.service.IBarService;

@RestController
@RequestMapping(path = "/app/bar")
public class BarRestController {

	@Autowired
	private IBarService barService;

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public void create(@RequestBody BarDto barDto) {
		barService.create(barDto);
	}

	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public void update(@RequestBody BarDto barDto) {
		barService.update(barDto);
	}

	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	public void delete(@RequestBody BarDto barDto) {
		barService.create(barDto);
	}

	@RequestMapping(path = "/findAll", method = RequestMethod.POST)
	public List<BarDto> findAll() {
		return barService.findAll();
	}

}
