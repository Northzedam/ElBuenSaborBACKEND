package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Articulo;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {

	public Page <Articulo> findAll(Pageable pageable);
}
