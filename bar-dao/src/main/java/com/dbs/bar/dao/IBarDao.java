package com.dbs.bar.dao;

import java.util.List;

import com.dbs.bar.dto.BarDto;

public interface IBarDao {

	void create(BarDto barDto);

	void update(BarDto barDto);

	void delete(BarDto barDto);

	List<BarDto> findAll();

}
