package com.dbs.bar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.bar.entity.Bar;

public interface BarRepository extends JpaRepository<Bar, Integer> {

}
