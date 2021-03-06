package com.dbs.bar.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.bar.dto.CatalogDto;
import com.dbs.bar.service.ICatalogService;

@RestController
@RequestMapping(path = "/app/catalogs")
public class CatalogRestController {

	@Autowired
	private ICatalogService catalogService;

	@RequestMapping(method = RequestMethod.POST)
	public void create(@RequestBody CatalogDto catalogDto) {
		catalogService.create(catalogDto);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody CatalogDto catalogDto) {
		catalogService.update(catalogDto);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@RequestBody CatalogDto catalogDto) {
		catalogService.delete(catalogDto);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<CatalogDto> findAll() {
		return catalogService.findAll();
	}
	
	@RequestMapping(path = "/bar/{barId}", method = RequestMethod.GET)
	public List<CatalogDto> findByBar(@PathVariable Integer barId) {
		return catalogService.findByBarId(barId);
	}

}
