package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Configuracion;

@Repository
public interface ConfiguracionRepository extends JpaRepository<Configuracion, Long> {

	public Page <Configuracion> findAll(Pageable pageable);
}
