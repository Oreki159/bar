package com.dbs.bar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.bar.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>  {

}
