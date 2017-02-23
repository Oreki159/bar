package com.dbs.bar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.bar.entity.Reputation;

public interface ReputationRepository extends JpaRepository<Reputation, Integer> {

}
