package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ArticuloManufacturado;
import com.example.demo.entity.DetallePedido;
import com.example.demo.entity.EstadoPedido;
import com.example.demo.entity.Pedido;
import com.example.demo.repository.EstadoPedidoRepository;
import com.example.demo.repository.PedidoRepository;
import com.example.demo.dtos.ArticuloConsumoDto;
import com.example.demo.dtos.ArticuloManufacturadoDto;
import com.example.demo.dtos.DetallePedidoDto;
import com.example.demo.dtos.PedidoDto;

@Service
public class PedidoServicio {


	PedidoRepository repository;
	
	EstadoPedidoRepository estadoPedidoRepository;

	public PedidoServicio(PedidoRepository repository, EstadoPedidoRepository estadoPedidoRepository) {
		this.repository = repository;
		this.estadoPedidoRepository = estadoPedidoRepository;
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
				dto.setHoraFin(entity.getHoraFin());
				dto.setConEnvio(entity.getConEnvio());
				
				dto.setNombreCliente(entity.getCliente().getNombre()+" "+entity.getCliente().getApellido());
				dto.setDomicilioCliente(entity.getCliente().getDomicilio().getCalle()+" "+entity.getCliente().getDomicilio().getNumero()+", "
						+entity.getCliente().getDomicilio().getLocalidad()+" - "+entity.getCliente().getDomicilio().getDepartamento());
				dto.setTelCliente(entity.getCliente().getTelefono());
				dto.setIdEstadoPedido(entity.getEstadoPedido().getId());
				dto.setStringEstadoPedido(entity.getEstadoPedido().getEstadoPedido());
				dto.setFechaAnulado(entity.getFechaAnulado());
			
				String detallesConcatenados = "";
				
				for(DetallePedido entityDetalle : entity.getDetalles()) {
					if(entityDetalle.getPedido().getId() == entity.getId()) {
						
						/*
						DetallePedidoDto dtoDetalle = new DetallePedidoDto();
						dtoDetalle.setId(entityDetalle.getId());
						dtoDetalle.setCantidad(entityDetalle.getCantidad());
						ArticuloConsumoDto articuloConsumoDto = new ArticuloConsumoDto();
						articuloConsumoDto.setDenominacion(entityDetalle.getArticuloConsumo().getDenominacion());
						articuloConsumoDto.setPrecioCompra(entityDetalle.getArticuloConsumo().getPrecioCompra());
						articuloConsumoDto.setPrecioVenta(entityDetalle.getArticuloConsumo().getPrecioVenta());
						articuloConsumoDto.setEsInsumo(entityDetalle.getArticuloConsumo().isEsInsumo());
						articuloConsumoDto.setUnidadMedida(entityDetalle.getArticuloConsumo().getUnidadMedida());
						

						ArticuloManufacturadoDto articuloManufacturadoDto = new ArticuloManufacturadoDto();
						ArticuloManufacturado articuloManufacturadoEntity = entityDetalle.getArticuloManufacturado();
						articuloManufacturadoDto.setId(articuloManufacturadoEntity.getId());
						articuloManufacturadoDto.setDenominacion(articuloManufacturadoEntity.getDenominacion());
						articuloManufacturadoDto.setPrecioVenta(articuloManufacturadoEntity.getPrecioVenta());
						articuloManufacturadoDto.setTiempoEstimadoCocina(articuloManufacturadoEntity.getTiempoEstimadoCocina());
						dtoDetalle.setArticuloConsumoDto(articuloConsumoDto);
						dtoDetalle.setArticuloManufacturadoDto(articuloManufacturadoDto);
						*/

	                    if(entityDetalle.getArticuloManufacturado() == null) {
							detallesConcatenados += entityDetalle.getArticuloConsumo().getDenominacion()+" x "+ entityDetalle.getCantidad()+". ";
	                    }else {
							detallesConcatenados += entityDetalle.getArticuloManufacturado().getDenominacion()+" x "+ entityDetalle.getCantidad()+". ";
	                    }
					    
						/*
						dto.getDetalles().add(dtoDetalle);
						*/
					}					
				}
				dto.setStringDetallePedido(detallesConcatenados);
				
				dtos.add(dto);
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
				dto.setHoraFin(entity.getHoraFin());
				dto.setConEnvio(entity.getConEnvio());
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
		
		entity.setFecha(dto.getFecha());
		entity.setNumero(dto.getNumero());
		entity.setEstado(dto.getEstado());
		entity.setHoraFin(dto.getHoraFin());
		entity.setConEnvio(dto.getConEnvio());		
		
		try {
			entity = repository.save(entity);
			dto.setId(entity.getId());
			return dto;
		} catch (Exception e) {
			throw new Exception();	
		}
		
			
	}
	
	public PedidoDto update(long id, PedidoDto dto, boolean estado) throws Exception {
		Optional<Pedido> optionalEntity = repository.findById(id);
		
		try {
			 Pedido entity = optionalEntity.get();
			    entity.setId(id);
			    entity.setFecha(dto.getFecha());
				entity.setNumero(dto.getNumero());
				entity.setEstado(dto.getEstado());
				entity.setHoraFin(dto.getHoraFin());
				entity.setConEnvio(dto.getConEnvio());
				entity.setFechaAnulado(dto.getFechaAnulado());

				EstadoPedido epTemp = new EstadoPedido();
				Optional<EstadoPedido>epEntityOptional = estadoPedidoRepository.findById((long)dto.getIdEstadoPedido());
				epTemp = epEntityOptional.get();
				entity.setEstadoPedido(epTemp);

			 
			 repository.save(entity);
			 dto.setId(entity.getId());
			 System.out.println("salió todo bien");
			 return dto;
			 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Falló método Update de PedidoService: "+e.getMessage());

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

