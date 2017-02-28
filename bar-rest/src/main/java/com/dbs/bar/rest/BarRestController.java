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
@RequestMapping(path = "/app/bars")
public class BarRestController {

	@Autowired
	private IBarService barService;

	@RequestMapping(method = RequestMethod.POST)
	public void create(@RequestBody BarDto barDto) {
		barService.create(barDto);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody BarDto barDto) {
		barService.update(barDto);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@RequestBody BarDto barDto) {
		barService.delete(barDto);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<BarDto> findAll() {
		return barService.findAll();
	}

}
