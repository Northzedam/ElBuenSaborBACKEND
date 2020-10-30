package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	public Page <Pedido> findAll(Pageable pageable);
	
	
	@Query("SELECT p FROM Pedido p WHERE p.estado = :status")
	public List<Pedido> findPedidosByStatus(@Param("status") String status);
	
	@Query("SELECT p FROM Pedido p WHERE p.estado <> 'terminado' ")
	public List<Pedido> findPedidosNoFinalizados();
}
