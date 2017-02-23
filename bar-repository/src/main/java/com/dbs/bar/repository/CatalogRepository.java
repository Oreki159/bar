package com.dbs.bar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.bar.entity.Catalog;

public interface CatalogRepository extends JpaRepository<Catalog, Integer> {

}
