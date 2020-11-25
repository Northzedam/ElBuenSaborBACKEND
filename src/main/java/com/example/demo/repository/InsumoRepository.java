package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Articulo;
import com.example.demo.entity.Insumo;

@Repository
public interface InsumoRepository extends JpaRepository<Insumo, Long> {

	public Page <Insumo> findAll(Pageable pageable);
	
	@Query("SELECT i FROM Insumo i WHERE i.StockActual < i.stockMinimo")
	public List<Insumo> findInsumosStockDebajoDelMinimo();
}
