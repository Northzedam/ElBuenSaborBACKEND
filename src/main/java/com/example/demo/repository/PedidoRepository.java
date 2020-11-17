package com.example.demo.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
	
	@Query("SELECT p FROM Pedido p "
			+ "INNER JOIN p.cliente cli "
			+ "INNER JOIN p.estadoPedido ep "
			+ "LEFT JOIN p.factura factura "
			+ "WHERE "
			+ "((?1 IS TRUE AND p.conEnvio =?2) OR ?1 IS FALSE) "			
			+ "AND (?3 < 1L OR (?3 > 0L AND ep.id =?3)) "
			+ "AND (upper(cli.nombre) LIKE concat('%' , upper(?4) , '%') OR upper(cli.apellido) LIKE concat('%' , upper(?4) , '%')) "
			+ "AND p.fecha > ?5 "
			+ "AND p.fecha < ?6 "
			+ "AND ((?7 IS TRUE AND factura.id IS NOT NULL) OR (?7 IS FALSE AND factura.id IS NULL)) "
			+ "AND ((?8 IS TRUE AND p.fechaAnulado IS NOT NULL) OR (?8 IS FALSE AND p.fechaAnulado IS NULL)) ")			
			
	Page<Pedido> findByNombre(boolean usarParamConEnvio, boolean conEnvio, long idEstadoPedido, String frase, Date fechaDesde, Date fechaHasta, boolean esFacturado, boolean tieneFechaAnulado, Pageable pageable);
	
	@Query("SELECT p FROM Pedido p WHERE p.estado <> 'terminado' ")
	Page<Pedido> findByConEnvioAndIdEstadoPedido(boolean conEnvio, long idEstadoPedido, Pageable pageable);

}
