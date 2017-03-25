package com.dbs.bar.dao;

import java.util.List;

import com.dbs.bar.dto.BarDto;

public interface IBarDao {

	/**
	 * Inserta un registro en la base de datos
	 * 
	 * @param barDto
	 */
	void create(BarDto barDto);

	/**
	 * Actualiza un registro en la base de datos
	 * 
	 * @param barDto
	 */
	void update(BarDto barDto);

	/**
	 * Elimina un registro en la base de datos
	 * 
	 * @param barDto
	 */
	void delete(BarDto barDto);

	/**
	 * Obtiene todos los registros de la tabla <code>BARS</code> de la base de
	 * datos
	 * 
	 * @return List<BarDto>
	 */
	List<BarDto> findAll();

}
