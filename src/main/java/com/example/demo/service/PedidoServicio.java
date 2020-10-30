package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ArticuloConsumo;
import com.example.demo.entity.DetallePedido;
import com.example.demo.entity.Pedido;
import com.example.demo.repository.ArticuloConsumoRepository;
import com.example.demo.repository.PedidoRepository;
import com.example.demo.dtos.ArticuloConsumoDto;
import com.example.demo.dtos.DetallePedidoDto;
import com.example.demo.dtos.PedidoDto;

@Service
public class PedidoServicio {


	PedidoRepository repository;
	ArticuloConsumoRepository artConsRepository;
	ArticuloConsumoServicio artConsService = new ArticuloConsumoServicio(artConsRepository);
	
	public static int tiempoDeCola=0;

	public PedidoServicio(PedidoRepository repository,ArticuloConsumoRepository artConsRepository) {
		this.repository = repository;
		this.artConsRepository = artConsRepository;
	}
	
	public List<PedidoDto> findAll() throws Exception {
		
		List<Pedido>entities = repository.findAll();
		List<PedidoDto>dtos = new ArrayList<PedidoDto>();
		List<DetallePedidoDto>detalles = new ArrayList<DetallePedidoDto>();
		try {
			
			for(Pedido entity : entities) {
				PedidoDto dto = new PedidoDto();
				dto.setId(entity.getId());
				dto.setFecha(entity.getFecha());
				dto.setNumero(entity.getNumero());
				dto.setEstado(entity.getEstado());
				dto.setTiempoRequerido(entity.getTiempoRequerido());
				dto.setTipoEnvio(entity.getTipoEnvio());
				dto.setCliente(entity.getCliente());
				
				for(DetallePedido entityDetalle : entity.getDetalles()) {
					DetallePedidoDto dtoDetalle = new DetallePedidoDto();
					dtoDetalle.setId(entityDetalle.getId());
					dtoDetalle.setCantidad(entityDetalle.getCantidad());
					
					ArticuloConsumoDto articuloConsumoDto = new ArticuloConsumoDto();
					articuloConsumoDto.setDenominacion(entityDetalle.getArticuloConsumo().getDenominacion());
					articuloConsumoDto.setPrecioCompra(entityDetalle.getArticuloConsumo().getPrecioCompra());
					articuloConsumoDto.setPrecioVenta(entityDetalle.getArticuloConsumo().getPrecioVenta());
					articuloConsumoDto.setEsInsumo(entityDetalle.getArticuloConsumo().isEsInsumo());
					articuloConsumoDto.setUnidadMedida(entityDetalle.getArticuloConsumo().getUnidadMedida());
					articuloConsumoDto.setStockActual(entityDetalle.getArticuloConsumo().getStockActual());
					articuloConsumoDto.setStockMinimo(entityDetalle.getArticuloConsumo().getStockMinimo());
					articuloConsumoDto.setTiempoEstimadoCocina(entityDetalle.getArticuloConsumo().getTiempoEstimadoCocina());
					dtoDetalle.setArticuloConsumoDto(articuloConsumoDto);

					
					dto.getDetalles().add(dtoDetalle);
				}
				dtos.add(dto);
			}
						
			return dtos;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public List<PedidoDto> findPedidosByStatus(String status) throws Exception{
		
		List<Pedido>entities = repository.findPedidosByStatus(status);
		List<PedidoDto>dtos = new ArrayList<PedidoDto>();
		List<DetallePedidoDto>detalles = new ArrayList<DetallePedidoDto>();
		try {
			
			for(Pedido entity : entities) {
				PedidoDto dto = new PedidoDto();
				dto.setId(entity.getId());
				dto.setFecha(entity.getFecha());
				dto.setNumero(entity.getNumero());
				dto.setEstado(entity.getEstado());
				dto.setTiempoRequerido(entity.getTiempoRequerido());
				dto.setTipoEnvio(entity.getTipoEnvio());
				dto.setCliente(entity.getCliente());
				
				for(DetallePedido entityDetalle : entity.getDetalles()) {
					DetallePedidoDto dtoDetalle = new DetallePedidoDto();
					dtoDetalle.setId(entityDetalle.getId());
					dtoDetalle.setCantidad(entityDetalle.getCantidad());
					
					ArticuloConsumoDto articuloConsumoDto = new ArticuloConsumoDto();
					articuloConsumoDto.setDenominacion(entityDetalle.getArticuloConsumo().getDenominacion());
					articuloConsumoDto.setPrecioCompra(entityDetalle.getArticuloConsumo().getPrecioCompra());
					articuloConsumoDto.setPrecioVenta(entityDetalle.getArticuloConsumo().getPrecioVenta());
					articuloConsumoDto.setEsInsumo(entityDetalle.getArticuloConsumo().isEsInsumo());
					articuloConsumoDto.setUnidadMedida(entityDetalle.getArticuloConsumo().getUnidadMedida());
					articuloConsumoDto.setStockActual(entityDetalle.getArticuloConsumo().getStockActual());
					articuloConsumoDto.setStockMinimo(entityDetalle.getArticuloConsumo().getStockMinimo());
					articuloConsumoDto.setTiempoEstimadoCocina(entityDetalle.getArticuloConsumo().getTiempoEstimadoCocina());
					dtoDetalle.setArticuloConsumoDto(articuloConsumoDto);

					
					dto.getDetalles().add(dtoDetalle);
				}
				dtos.add(dto);
			}
						
			return dtos;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
public List<PedidoDto> findPedidosNoFinalizados() throws Exception {
		
		List<Pedido>entities = repository.findPedidosNoFinalizados();
		List<PedidoDto>dtos = new ArrayList<PedidoDto>();
		List<DetallePedidoDto>detalles = new ArrayList<DetallePedidoDto>();
		try {
			
			for(Pedido entity : entities) {
				PedidoDto dto = new PedidoDto();
				dto.setId(entity.getId());
				dto.setFecha(entity.getFecha());
				dto.setNumero(entity.getNumero());
				dto.setEstado(entity.getEstado());
				dto.setTiempoRequerido(entity.getTiempoRequerido());
				dto.setTipoEnvio(entity.getTipoEnvio());
				dto.setCliente(entity.getCliente());
				
				for(DetallePedido entityDetalle : entity.getDetalles()) {
					DetallePedidoDto dtoDetalle = new DetallePedidoDto();
					dtoDetalle.setId(entityDetalle.getId());
					dtoDetalle.setCantidad(entityDetalle.getCantidad());
					
					ArticuloConsumoDto articuloConsumoDto = new ArticuloConsumoDto();
					articuloConsumoDto.setDenominacion(entityDetalle.getArticuloConsumo().getDenominacion());
					articuloConsumoDto.setPrecioCompra(entityDetalle.getArticuloConsumo().getPrecioCompra());
					articuloConsumoDto.setPrecioVenta(entityDetalle.getArticuloConsumo().getPrecioVenta());
					articuloConsumoDto.setEsInsumo(entityDetalle.getArticuloConsumo().isEsInsumo());
					articuloConsumoDto.setUnidadMedida(entityDetalle.getArticuloConsumo().getUnidadMedida());
					articuloConsumoDto.setStockActual(entityDetalle.getArticuloConsumo().getStockActual());
					articuloConsumoDto.setStockMinimo(entityDetalle.getArticuloConsumo().getStockMinimo());
					articuloConsumoDto.setTiempoEstimadoCocina(entityDetalle.getArticuloConsumo().getTiempoEstimadoCocina());
					dtoDetalle.setArticuloConsumoDto(articuloConsumoDto);

					
					dto.getDetalles().add(dtoDetalle);
				}
				dtos.add(dto);
			}
						
			return dtos;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public List<PedidoDto> findPedidosByClienteId(int idCliente) throws Exception {
		
		List<Pedido>entities = repository.findAll();
		List<PedidoDto>dtos = new ArrayList<PedidoDto>();
		try {
			
			for(Pedido entity : entities) {
				if(entity.getCliente().getId()==idCliente) {
					PedidoDto dto = new PedidoDto();
					dto.setId(entity.getId());
					dto.setFecha(entity.getFecha());
					dto.setNumero(entity.getNumero());
					dto.setEstado(entity.getEstado());
					dto.setTiempoRequerido(entity.getTiempoRequerido());
					dto.setTipoEnvio(entity.getTipoEnvio());
					dtos.add(dto);
				}				
			}
						
			return dtos;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	
	public PedidoDto findById(int id) throws Exception{
		
		Optional<Pedido>entityOptional = repository.findById((long) id);
		
		PedidoDto dto = new PedidoDto();
		
		try {
			 Pedido entity = entityOptional.get();
			
				dto.setId(entity.getId());
				dto.setFecha(entity.getFecha());
				dto.setNumero(entity.getNumero());
				dto.setEstado(entity.getEstado());
				dto.setTiempoRequerido(entity.getTiempoRequerido());
				dto.setTipoEnvio(entity.getTipoEnvio());
				for(DetallePedido entityDetalle : entity.getDetalles()) {
					DetallePedidoDto dtoDetalle = new DetallePedidoDto();
					dtoDetalle.setId(entityDetalle.getId());
					dtoDetalle.setCantidad(entityDetalle.getCantidad());
					//dtoDetalle.setArticuloConsumo(entityDetalle.getArticuloConsumo());
					
					dto.getDetalles().add(dtoDetalle);
				}

		} catch (Exception e) {
			throw new Exception();
		}
		
		return dto;
	}
	
		
    public PedidoDto save(PedidoDto dto, boolean estado) throws Exception {
		Pedido entity = new Pedido();
		int tiempoRequerido=0;
		entity.setFecha(dto.getFecha());
		entity.setNumero(dto.getNumero());
		entity.setEstado(dto.getEstado());
		
		
		entity.setTipoEnvio(dto.getTipoEnvio());
		
		for(DetallePedidoDto detalleDto : dto.getDetalles()) {
			DetallePedido detalleEntity = new DetallePedido();
			detalleEntity.setCantidad(detalleDto.getCantidad());
			detalleEntity.setSubtotal(detalleDto.getSubtotal());
			ArticuloConsumo artConsumoEntity = artConsRepository.getOne(detalleDto.getArticuloConsumoId());
			if(artConsumoEntity.getStockActual() > artConsumoEntity.getStockMinimo()) {
				artConsumoEntity.setStockActual(artConsumoEntity.getStockActual() - detalleDto.getCantidad());
			}else {
				throw new Exception("Stock insuficiente");
			}
			
			tiempoRequerido+=(artConsumoEntity.getTiempoEstimadoCocina()*detalleDto.getCantidad());
			detalleEntity.setArticuloConsumo(artConsumoEntity);			
			entity.getDetalles().add(detalleEntity);
		}
		entity.setTiempoRequerido(tiempoRequerido);
		try {
			entity = repository.save(entity);	
			dto.setId(entity.getId());
			
			
			return dto;
		} catch (Exception e) {
			throw new Exception();	
		}
		
			
	}
	
	public PedidoDto update(int id, PedidoDto dto, boolean estado) throws Exception {
		Optional<Pedido> optionalEntity = repository.findById((long) id);
		
		try {
			 Pedido entity = optionalEntity.get();
			    entity.setId(id);
			    entity.setFecha(dto.getFecha());
				entity.setNumero(dto.getNumero());
				entity.setEstado(dto.getEstado());
				entity.setTiempoRequerido(dto.getTiempoRequerido());
				entity.setTipoEnvio(dto.getTipoEnvio());



			 
			 repository.save(entity);
			 dto.setId(entity.getId());
			 return dto;
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dto;
	}
			
	public boolean delete(int id) throws Exception {
		try {
			if(repository.existsById((long) id)) {
				repository.deleteById((long) id);
				return true;
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception();
		}
		
	}
	
	
	public int countPages(int size) throws Exception {
		try {
			Pageable pageable = PageRequest.of(0, size);
			return repository.findAll(pageable).getTotalPages();			

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	
	
	
}

