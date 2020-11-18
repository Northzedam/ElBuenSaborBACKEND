package com.example.demo.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Articulo;
import com.example.demo.entity.DetallePedido;
import com.example.demo.entity.DetalleReceta;
import com.example.demo.entity.Pedido;
import com.example.demo.repository.ArticuloRepository;
import com.example.demo.repository.InsumoRepository;
import com.example.demo.entity.EstadoPedido;
import com.example.demo.repository.EstadoPedidoRepository;
import com.example.demo.repository.PedidoRepository;
import com.example.demo.repository.RubroArticuloRepository;
import com.example.demo.dtos.ArticuloDto;
import com.example.demo.dtos.DetallePedidoDto;
import com.example.demo.dtos.DetalleRecetaDto;
import com.example.demo.dtos.PedidoDto;

@Service
public class PedidoServicio {


	PedidoRepository repository;
	ArticuloRepository articuloRepository;
	EstadoPedidoRepository estadoPedidoRepository;
	InsumoRepository insumoRepository;
	RubroArticuloRepository rubroArticuloRepository;
	ArticuloServicio artConsService = new ArticuloServicio(articuloRepository, insumoRepository,rubroArticuloRepository);
	
	public static int tiempoDeCola=0;

	public PedidoServicio(PedidoRepository repository,ArticuloRepository articuloRepository, EstadoPedidoRepository estadoPedidoRepository) {
		this.repository = repository;
		this.articuloRepository = articuloRepository;
		this.estadoPedidoRepository = estadoPedidoRepository;
	}
	
	public List<PedidoDto> findAll() throws Exception {
		
		List<Pedido>entities = repository.findAll();
		List<PedidoDto>dtos = new ArrayList<PedidoDto>();
		List<DetallePedidoDto>detalles = new ArrayList<DetallePedidoDto>();
		try {
			
			for(Pedido entity : entities) {
				PedidoDto dto = new PedidoDto();
				dto = this.convertEntidadAPedidoDTO(entity);
				
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
				dto.setCliente(entity.getCliente());
				
				for(DetallePedido entityDetalle : entity.getDetalles()) {
					DetallePedidoDto dtoDetalle = new DetallePedidoDto();
					dtoDetalle.setId(entityDetalle.getId());
					dtoDetalle.setCantidad(entityDetalle.getCantidad());
					
					ArticuloDto ArticuloDto = new ArticuloDto();
					ArticuloDto.setDenominacion(entityDetalle.getArticulo().getDenominacion());
					ArticuloDto.setPrecioCompra(entityDetalle.getArticulo().getPrecioCompra());
					ArticuloDto.setPrecioVenta(entityDetalle.getArticulo().getPrecioVenta());
					ArticuloDto.setEsManufacturado(entityDetalle.getArticulo().isEsManufacturado());	
					ArticuloDto.setTiempoCocina(entityDetalle.getArticulo().getTiempoCocina());
					dtoDetalle.setArticuloDto(ArticuloDto);

					
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
				dto.setCliente(entity.getCliente());
				
				for(DetallePedido entityDetalle : entity.getDetalles()) {
					DetallePedidoDto dtoDetalle = new DetallePedidoDto();
					dtoDetalle.setId(entityDetalle.getId());
					dtoDetalle.setCantidad(entityDetalle.getCantidad());
					
					ArticuloDto ArticuloDto = new ArticuloDto();
					ArticuloDto.setId(entityDetalle.getArticulo().getId());
					ArticuloDto.setDenominacion(entityDetalle.getArticulo().getDenominacion());
					ArticuloDto.setPrecioCompra(entityDetalle.getArticulo().getPrecioCompra());
					ArticuloDto.setPrecioVenta(entityDetalle.getArticulo().getPrecioVenta());
					ArticuloDto.setEsManufacturado(entityDetalle.getArticulo().isEsManufacturado());	
					ArticuloDto.setTiempoCocina(entityDetalle.getArticulo().getTiempoCocina());
					
					 List<DetalleRecetaDto>detallesReceta = new ArrayList<DetalleRecetaDto>();
						
						
						for(DetalleReceta detalleReceta : entityDetalle.getArticulo().getDetallesReceta()) {
							DetalleRecetaDto detalleRecetaDto = new DetalleRecetaDto();
							detalleRecetaDto.setId(detalleReceta.getId());
							detalleRecetaDto.setCantidad(detalleReceta.getCantidad());
							detalleRecetaDto.getInsumo().setId(detalleReceta.getInsumo().getId());
							detalleRecetaDto.getInsumo().setDenominacion(detalleReceta.getInsumo().getDenominacion());
							detalleRecetaDto.getInsumo().setPrecioCompra(detalleReceta.getInsumo().getPrecioCompra());
							detalleRecetaDto.getInsumo().setStockActual(detalleReceta.getInsumo().getStockActual());
							detalleRecetaDto.getInsumo().setStockMinimo(detalleReceta.getInsumo().getStockMinimo());
							detallesReceta.add(detalleRecetaDto);
						}
						ArticuloDto.setDetalles(detallesReceta);
					
					
					dtoDetalle.setArticuloDto(ArticuloDto);

					
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
			dto = this.convertEntidadAPedidoDTO(entity);

		} catch (Exception e) {
			throw new Exception();
		}
		
		return dto;
	}
	
		
    public PedidoDto save(PedidoDto dto, boolean estado) throws Exception {
    	boolean error=false;
		Pedido entity = new Pedido();
		int tiempoRequerido=0;
		entity.setFecha(dto.getFecha());
		entity.setNumero(dto.getNumero());
		entity.setEstado(dto.getEstado());
		entity.setHoraFin(dto.getHoraFin());
		entity.setConEnvio(dto.getConEnvio());	
		
		for(DetallePedidoDto detalleDto : dto.getDetalles()) {
			DetallePedido detalleEntity = new DetallePedido();
			detalleEntity.setCantidad(detalleDto.getCantidad());
			detalleEntity.setSubtotal(detalleDto.getSubtotal());
			Articulo articuloEntity = articuloRepository.getOne(detalleDto.getArticuloDto().getId());
			// CONTROL DE STOCK
			for(DetalleReceta detalle : articuloEntity.getDetallesReceta()) {
				if((detalle.getInsumo().getStockActual() > detalle.getInsumo().getStockMinimo()) && (detalle.getInsumo().getStockActual() > detalle.getCantidad()*detalleDto.getCantidad() )) { // controla que el stock actual sea mayor que el minimo
						detalle.getInsumo().setStockActual(detalle.getInsumo().getStockActual() - (detalle.getCantidad()*detalleDto.getCantidad()));		
				}else {
					error = true;
					throw new Exception("Stock insuficiente");
				}
			}
			
			tiempoRequerido+=(articuloEntity.getTiempoCocina()*detalleDto.getCantidad());
			detalleEntity.setArticulo(articuloEntity);			
			entity.getDetalles().add(detalleEntity);
		}
		entity.setTiempoRequerido(tiempoRequerido);
		
			try {
					if(error) {
						entity=null;
					}
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
				entity.setTiempoRequerido(dto.getTiempoRequerido());
				entity.setHoraFin(dto.getHoraFin());
				entity.setConEnvio(dto.getConEnvio());
				entity.setFechaAnulado(dto.getFechaAnulado());
				entity.setFactura(dto.getFactura());

				EstadoPedido epTemp = new EstadoPedido();
				Optional<EstadoPedido>epEntityOptional = estadoPedidoRepository.findById((long)dto.getIdEstadoPedido());
				epTemp = epEntityOptional.get();
				entity.setEstadoPedido(epTemp);
				
				//le doy valor string de estadoPedido
				dto.setStringEstadoPedido(epTemp.getEstadoPedido());

			 
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
	
	//FindByFrase
	public Page<PedidoDto> findByFrase(boolean usarParamConEnvio, boolean conEnvio, long idEstadoPedido, String frase, Date  fechaDesde, Date fechaHasta, boolean esFacturado, boolean tieneFechaAnulado, Pageable pageable){
		
		Page<Pedido> pedidosEntity = repository.findByNombre(usarParamConEnvio, conEnvio, idEstadoPedido, frase, fechaDesde, fechaHasta, esFacturado, tieneFechaAnulado, pageable);
		Page<PedidoDto> pedidosDto = null;
		try {
			pedidosDto = pedidosEntity.map(new Function<Pedido, PedidoDto>() {
				
				public PedidoDto apply(Pedido t) {
					return convertEntidadAPedidoDTO(t);
				}

	        });	
		}catch(Exception e){
			System.out.println("MANSO ERROR: "+e.getMessage());
		}
		
		
		return pedidosDto;		

	}
	
	private PedidoDto convertEntidadAPedidoDTO(Pedido entity) {
		PedidoDto dto = new PedidoDto();
		dto.setId(entity.getId());
		dto.setFecha(entity.getFecha());
		dto.setNumero(entity.getNumero());
		dto.setEstado(entity.getEstado());
		dto.setTiempoRequerido(entity.getTiempoRequerido());
		dto.setHoraFin(entity.getHoraFin());
		dto.setConEnvio(entity.getConEnvio());
		
		dto.setNombreCliente(entity.getCliente().getNombre()+" "+entity.getCliente().getApellido());
		dto.setDomicilioCliente(entity.getCliente().getDomicilio().getCalle()+" "+entity.getCliente().getDomicilio().getNumero()+", "
				+entity.getCliente().getDomicilio().getLocalidad()+" - "+entity.getCliente().getDomicilio().getDepartamento());
		dto.setTelCliente(entity.getCliente().getTelefono());
		dto.setEmailCliente(entity.getCliente().getEmail());
		dto.setIdEstadoPedido(entity.getEstadoPedido().getId());
		dto.setStringEstadoPedido(entity.getEstadoPedido().getEstadoPedido());
		dto.setFechaAnulado(entity.getFechaAnulado());
		
		String detallesConcatenados = "";
		
		for(DetallePedido entityDetalle : entity.getDetalles()) {
			DetallePedidoDto dtoDetalle = new DetallePedidoDto();
			dtoDetalle.setId(entityDetalle.getId());
			dtoDetalle.setCantidad(entityDetalle.getCantidad());
			
			ArticuloDto ArticuloDto = new ArticuloDto();
			
			ArticuloDto.setDenominacion(entityDetalle.getArticulo().getDenominacion());
			ArticuloDto.setPrecioCompra(entityDetalle.getArticulo().getPrecioCompra());
			ArticuloDto.setPrecioVenta(entityDetalle.getArticulo().getPrecioVenta());
			ArticuloDto.setEsManufacturado(entityDetalle.getArticulo().isEsManufacturado());	
			ArticuloDto.setTiempoCocina(entityDetalle.getArticulo().getTiempoCocina());
			dtoDetalle.setArticuloDto(ArticuloDto);
			
			detallesConcatenados += entityDetalle.getArticulo().getDenominacion()+" x "+ entityDetalle.getCantidad()+". ";
                			
			dto.getDetalles().add(dtoDetalle);				
		}				
		dto.setStringDetallePedido(detallesConcatenados);		
		return dto;
	}
	
	public List <PedidoDto> findByIdEstadoPedido(int idEstadoPedido) throws Exception{
		
		List<Pedido> entities = repository.findAll();
		List<PedidoDto> dtos = new ArrayList<PedidoDto>();
		
		try {
			
			for(Pedido entity : entities) {
				if(entity.getEstadoPedido().getId() == (long)idEstadoPedido) {
					PedidoDto dto = new PedidoDto();
					dto = this.convertEntidadAPedidoDTO(entity);
					dtos.add(dto);
				}
				
			}
			return dtos;
			
		} catch (Exception e) {
			
			throw new Exception();
		}
		
		
	}
	
	
}

