package com.dbs.bar.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.bar.dto.CatalogDto;
import com.dbs.bar.service.ICatalogService;

@RestController
@RequestMapping(path = "/app/catalog")
public class CatalogRestController {

	@Autowired
	private ICatalogService catalogService;

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public void create(@RequestBody CatalogDto catalogDto) {
		catalogService.create(catalogDto);
	}

	@RequestMapping(path = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody CatalogDto catalogDto) {
		catalogService.update(catalogDto);
	}

	@RequestMapping(path = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestBody CatalogDto catalogDto) {
		catalogService.delete(catalogDto);
	}

	@RequestMapping(path = "/findByBar", method = RequestMethod.GET)
	public List<CatalogDto> findByBar(@RequestBody CatalogDto catalogDto) {
		return catalogService.findByBar(catalogDto);
	}
	
	@RequestMapping(path = "/findAll", method = RequestMethod.GET)
	public List<CatalogDto> findAll() {
		return catalogService.findAll();
	}

}
