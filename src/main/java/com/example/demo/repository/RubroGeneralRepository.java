package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RubroGeneral;

@Repository
public interface RubroGeneralRepository extends JpaRepository<RubroGeneral, Long> {

	public Page <RubroGeneral> findAll(Pageable pageable);
}
