package com.dbs.bar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.bar.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
