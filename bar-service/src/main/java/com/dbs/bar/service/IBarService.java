package com.dbs.bar.service;

import java.util.List;

import com.dbs.bar.dto.BarDto;

/**
 * 
 * @author Jorge Luis Alvarez A.
 * @version 1.0.0
 *
 */
public interface IBarService {

	void create(BarDto barDto);

	void update(BarDto barDto);

	void delete(BarDto barDto);

	List<BarDto> findAll();

}
