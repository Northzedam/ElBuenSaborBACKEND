package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Articulo;
import com.example.demo.entity.DetalleFactura;
import com.example.demo.entity.DetallePedido;
import com.example.demo.entity.Factura;
import com.example.demo.entity.Pedido;
import com.example.demo.repository.ArticuloRepository;
import com.example.demo.repository.DetalleFacturaRepository;
import com.example.demo.repository.EstadoPedidoRepository;
import com.example.demo.repository.FacturaRepository;
import com.example.demo.repository.InsumoRepository;
import com.example.demo.repository.PedidoRepository;
import com.example.demo.dtos.ArticuloDto;
import com.example.demo.dtos.DetalleFacturaDto;
import com.example.demo.dtos.FacturaDto;

@Service
public class FacturaServicio {


	FacturaRepository repository;
	PedidoRepository pedidoRepository;
	ArticuloRepository articuloRepository;
	EstadoPedidoRepository estadoPedidoRepository;
	InsumoRepository insumoRepository;
	DetalleFacturaRepository detalleFacturaRepository;
	
	@Autowired (required = true)
	PedidoServicio pedidoService;
	
	@Autowired (required = true)
	DetalleFacturaServicio detFacServicio;
	
	@Autowired (required = true)
	ArticuloServicio artConsService;
	
	//PedidoServicio pedidoService = new PedidoServicio(pedidoRepository, articuloRepository, estadoPedidoRepository);
	
	public FacturaServicio(FacturaRepository repository, 
			PedidoRepository pedidoRepository,
			ArticuloRepository articuloRepository,
			EstadoPedidoRepository estadoPedidoRepository,
			InsumoRepository insumoRepository,
			DetalleFacturaRepository detalleFacturaRepository) {
		this.repository = repository;
		this.pedidoRepository = pedidoRepository;
		this.articuloRepository = articuloRepository;
		this.estadoPedidoRepository = estadoPedidoRepository;
		this.insumoRepository = insumoRepository;
		this.detalleFacturaRepository = detalleFacturaRepository;
	}
	
	public List<FacturaDto> findAll() throws Exception {
		
		List<Factura>entities = repository.findAll();
		List<FacturaDto>dtos = new ArrayList<FacturaDto>();
		try {
			
			for(Factura entity : entities) {
				FacturaDto dto = new FacturaDto();
				dto.setId(entity.getId());
				dto.setFecha(entity.getFecha());
				dto.setNumero(entity.getNumero());
				dto.setMontoDescuento(entity.getMontoDescuento());
				dto.setTotal(entity.getTotal());
				dto.setFormaDePago(entity.getFormaDePago());
				dto.setNroTarjeta(entity.getNroTarjeta());

				dtos.add(dto);
			}
			
			return dtos;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public FacturaDto findById(int id) throws Exception{
		
		Optional<Factura>entityOptional = repository.findById((long) id);
		
		FacturaDto dto = new FacturaDto();
		
		try {
			 Factura entity = entityOptional.get();
			
				dto.setId(entity.getId());
				dto.setFecha(entity.getFecha());
				dto.setNumero(entity.getNumero());
				dto.setMontoDescuento(entity.getMontoDescuento());
				dto.setTotal(entity.getTotal());
				dto.setFormaDePago(entity.getFormaDePago());
				dto.setNroTarjeta(entity.getNroTarjeta());


		} catch (Exception e) {
			throw new Exception();
		}
		
		return dto;
	}
	
		
    public FacturaDto save(FacturaDto dto, boolean estado) throws Exception {
		
		Factura entity = new Factura();
		
		entity.setFecha(dto.getFecha());
		entity.setNumero(dto.getNumero());
		entity.setMontoDescuento(dto.getMontoDescuento());
		entity.setTotal(dto.getTotal());
		entity.setFormaDePago(dto.getFormaDePago());
		entity.setNroTarjeta(dto.getNroTarjeta());		
		
		try {
			//primero guardo la factura
			entity = repository.save(entity);
			
			//segundo, le asigno esa factura al pedido al cual está vinculado
			Pedido pedido = this.pedidoRepository.getOne(dto.getPedido().getId());
			pedido.setFactura(entity);
			pedidoRepository.save(pedido);
			
			List<DetalleFacturaDto> detTemp = this.pasarDetallePedidoADetalleFactura(entity, pedido);
			
			dto.setDetallesDto(detTemp);
			
			//por último le doy al dto de factura el id creado en la BD y devuelvo el dto al controlador
			dto.setId(entity.getId());
			
			return dto;
		} catch (Exception e) {
			throw new Exception();	
		}
		
			
	}
    
    public List<DetalleFacturaDto> pasarDetallePedidoADetalleFactura(Factura factura, Pedido pedido) {
    	
    	List<DetalleFacturaDto> listadoDetalle = new ArrayList<DetalleFacturaDto>();
    	
    	try {
    		if(pedido.getDetalles().size() > 0) {    		
        		
        		for(DetallePedido detallePedido : pedido.getDetalles()) {
        			
        			double subtotal = detallePedido.getCantidad() * detallePedido.getArticulo().getPrecioVenta();
        			
        			DetalleFactura detFactura = new DetalleFactura(
        					detallePedido.getCantidad(),
        					subtotal, 
        					factura, 
        					detallePedido.getArticulo());    
        			
        			detFactura = this.detalleFacturaRepository.save(detFactura);
        			
        			DetalleFacturaDto itemDto = this.detFacServicio.findById((int)detFactura.getId());				
    				ArticuloDto art = this.artConsService.findSmallArticuloPorId((int)detFactura.getId()); 
    				
    				itemDto.setArticuloConsumoDto(art);
    				
    				listadoDetalle.add(itemDto);
        			
        		}
        	} 
		} catch (Exception e) {
			System.out.println("Rompe método 'pasarDetallePedidoADetalleFactura' en FacturaServicio: " + e.getMessage());
		}   	
    	
    	return listadoDetalle;
    }
	
	public FacturaDto update(int id, FacturaDto dto, boolean estado) throws Exception {
		Optional<Factura> optionalEntity = repository.findById((long) id);
		
		try {
			 Factura entity = optionalEntity.get();
			    entity.setId(id);
			    entity.setFecha(dto.getFecha());
				entity.setNumero(dto.getNumero());
				entity.setMontoDescuento(dto.getMontoDescuento());
				entity.setTotal(dto.getTotal());
				entity.setFormaDePago(dto.getFormaDePago());
				entity.setNroTarjeta(dto.getNroTarjeta());



			 
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
	
	public int findUltimoNroFactura() throws Exception {
		List<Factura> facturas = repository.findAll();
		
		int nroMaximo = 0;
		
		try {
			if(facturas.isEmpty()) {
				return nroMaximo;
			}else {
				for(Factura entity : facturas) {
					if(entity.getNumero() > nroMaximo) {
						nroMaximo = entity.getNumero();
					}
				}
				return nroMaximo;
			}			
			
		}catch(Exception e) {
			System.out.println("Error en FacturaService. Método: 'findUltimoNroFactura'. "+e.getMessage());
			throw new Exception(e.getMessage());
		}		
	}
	
	
}

