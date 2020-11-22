package com.example.demo.service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Articulo;
import com.example.demo.entity.DetalleReceta;
import com.example.demo.entity.Insumo;
import com.example.demo.entity.RubroArticulo;
import com.example.demo.repository.ArticuloRepository;
import com.example.demo.repository.InsumoRepository;
import com.example.demo.repository.RubroArticuloRepository;
import com.example.demo.ElBuenSabor2020Application;
import com.example.demo.dtos.ArticuloDto;
import com.example.demo.dtos.DetalleRecetaDto;
import com.example.demo.dtos.InsumoDto;
import com.example.demo.dtos.RubroArticuloDto;
import com.example.demo.dtos.UnidadMedidaDto;

@Service
public class ArticuloServicio {


	ArticuloRepository repository;
	InsumoRepository insumoRepository;
	RubroArticuloRepository rubroArticuloRepository;
	private String upload_folder = String.valueOf(ElBuenSabor2020Application.getHome()+ "\\images\\").replace("\\","/");


	public ArticuloServicio(ArticuloRepository repository,InsumoRepository insumoRepository,
			RubroArticuloRepository rubroArticuloRepository) {
		this.repository = repository;
		this.insumoRepository = insumoRepository;
		this.rubroArticuloRepository = rubroArticuloRepository;
	}
	
	
	
	public List<ArticuloDto> findAll() throws Exception {
		
		List<Articulo>entities = repository.findAll();
		List<ArticuloDto>dtos = new ArrayList<ArticuloDto>();
		try {
			
			for(Articulo entity : entities) {
				ArticuloDto dto = new ArticuloDto();
				dto.setId(entity.getId());
				dto.setDenominacion(entity.getDenominacion());
				dto.setPrecioCompra(entity.getPrecioCompra());
				dto.setPrecioVenta(entity.getPrecioVenta());
				dto.setEsManufacturado(entity.isEsManufacturado());
				dto.setImagen(entity.getImagen());
		        RubroArticuloDto rubroArticuloDto = new RubroArticuloDto();
		        rubroArticuloDto.setDenominacion(entity.getRubroArticulo().getDenominacion());
		        rubroArticuloDto.setId(entity.getRubroArticulo().getId());
		        dto.setRubroArticuloDto(rubroArticuloDto);
				
				
				 List<DetalleRecetaDto>detallesReceta = new ArrayList<DetalleRecetaDto>();
				
				
				for(DetalleReceta detalleReceta : entity.getDetallesReceta()) {
					DetalleRecetaDto detalleRecetaDto = new DetalleRecetaDto();
					detalleRecetaDto.setId(detalleReceta.getId());
					detalleRecetaDto.setCantidad(detalleReceta.getCantidad());
					InsumoDto insumoDto = new InsumoDto();
					insumoDto.setId(detalleReceta.getInsumo().getId());
					insumoDto.setDenominacion(detalleReceta.getInsumo().getDenominacion());
					insumoDto.setPrecioCompra(detalleReceta.getInsumo().getPrecioCompra());
					insumoDto.setStockActual(detalleReceta.getInsumo().getStockActual());
					insumoDto.setStockMinimo(detalleReceta.getInsumo().getStockMinimo());
					UnidadMedidaDto unidadMedidaDto = new UnidadMedidaDto();
					unidadMedidaDto.setId(detalleReceta.getInsumo().getUnidadMedida().getId());
					unidadMedidaDto.setUnidadMedida(detalleReceta.getInsumo().getUnidadMedida().getUnidadMedida());
					insumoDto.setUnidadMedida(unidadMedidaDto);
					detalleRecetaDto.setInsumo(insumoDto);
					detallesReceta.add(detalleRecetaDto);
				}
				dto.setDetalles(detallesReceta);
			
				dtos.add(dto);
			}
			

			return dtos;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public ArticuloDto findById(int id) throws Exception{
		
		Optional<Articulo>entityOptional = repository.findById((long) id);
		
		ArticuloDto dto = new ArticuloDto();
		
		try {
			 Articulo entity = entityOptional.get();
			
			 	dto.setId(entity.getId());
				dto.setDenominacion(entity.getDenominacion());
				dto.setPrecioCompra(entity.getPrecioCompra());
				dto.setPrecioVenta(entity.getPrecioVenta());
				dto.setEsManufacturado(entity.isEsManufacturado());
				dto.setImagen(entity.getImagen());
				RubroArticuloDto rubroArticuloDto = new RubroArticuloDto();
		        rubroArticuloDto.setDenominacion(entity.getRubroArticulo().getDenominacion());
		        rubroArticuloDto.setId(entity.getRubroArticulo().getId());
		        dto.setRubroArticuloDto(rubroArticuloDto);
		        
				 List<DetalleRecetaDto>detallesReceta = new ArrayList<DetalleRecetaDto>();
					
					
					for(DetalleReceta detalleReceta : entity.getDetallesReceta()) {
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
					dto.setDetalles(detallesReceta);
				
		} catch (Exception e) {
			System.out.println("Rompe findById de ArticuloDto: " + e.getMessage());
			throw new Exception();
		}
		
		return dto;
	}
	
	public ArticuloDto findSmallArticuloPorId(int id) throws Exception{
		
		Optional<Articulo>entityOptional = repository.findById((long) id);
		
		ArticuloDto dto = new ArticuloDto();
		
		try {
			if(!entityOptional.isEmpty()) {
				Articulo entity = entityOptional.get();
				
			 	dto.setId(entity.getId());
				dto.setDenominacion(entity.getDenominacion());
				dto.setPrecioCompra(entity.getPrecioCompra());
				dto.setPrecioVenta(entity.getPrecioVenta());
				dto.setEsManufacturado(entity.isEsManufacturado());
			}	        
				
		} catch (Exception e) {
			System.out.println("Rompe findSmallArticuloPorId de ArticuloDto: " + e.getMessage());
			throw new Exception();
		}
		
		return dto;
	}

	public Articulo findEntityById(long id) throws Exception{
		Optional<Articulo>entityOptional = repository.findById((long) id);
		try {
			Articulo artCons = entityOptional.get();
			return artCons;
		} catch (Exception e) {
			System.out.println("No se pudo obtener el artConsumo del optional---");
			return null;
		}
		
		
	}
		
    public ArticuloDto save(ArticuloDto dto, boolean estado) throws Exception {
		
		Articulo entity = new Articulo();
		
		entity.setDenominacion(dto.getDenominacion());
		entity.setPrecioCompra(dto.getPrecioCompra());
		entity.setPrecioVenta(dto.getPrecioVenta());	
		entity.setEsManufacturado(dto.isEsManufacturado());
		entity.setTiempoCocina(dto.getTiempoCocina());
		entity.setImagen(dto.getImagen());
		
		Optional<RubroArticulo>rubroArticuloOptional = (rubroArticuloRepository.findById(dto.getRubroArticuloDto().getId()));
		RubroArticulo rubroArticulo = rubroArticuloOptional.get();
		entity.setRubroArticulo(rubroArticulo);
		
	    List<DetalleReceta>detallesReceta = new ArrayList<DetalleReceta>();
		for(DetalleRecetaDto detalleRecetaDto : dto.getDetalles()) {
				DetalleReceta detalleReceta = new DetalleReceta();
				//detalleReceta.setId(detalleRecetaDto.getId());
				detalleReceta.setCantidad(detalleRecetaDto.getCantidad());
				Optional<Insumo>insumoOptional = (insumoRepository.findById(detalleRecetaDto.getInsumoId()));
				Insumo insumo = insumoOptional.get();
				detalleReceta.setInsumo(insumo);
				detallesReceta.add(detalleReceta);
			}
			entity.setDetallesReceta(detallesReceta);

		
		try {
			entity = repository.save(entity);
			dto.setId(entity.getId());
			return dto;
		} catch (Exception e) {
			throw new Exception();	
		}
		
			
	}
    
    public String saveImage(MultipartFile file) throws IOException {
		if(!file.isEmpty()) {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(upload_folder + file.getOriginalFilename());
			Files.write(path, bytes);
		}
		return(upload_folder);
		
	}

	
	public ArticuloDto update(int id, ArticuloDto dto, boolean estado) throws Exception {
		Optional<Articulo> optionalEntity = repository.findById((long) id);
		
		try {
			 Articulo entity = optionalEntity.get();
			    entity.setId(id);
			    entity.setDenominacion(dto.getDenominacion());
				entity.setPrecioCompra(dto.getPrecioCompra());
				entity.setPrecioVenta(dto.getPrecioVenta());	
				entity.setEsManufacturado(dto.isEsManufacturado());
				entity.setTiempoCocina(dto.getTiempoCocina());
				entity.setImagen(dto.getImagen());
				entity.setImagen(dto.getImagen());
				RubroArticulo rubroArticulo = new RubroArticulo();
		        rubroArticulo.setDenominacion(dto.getRubroArticuloDto().getDenominacion());
		        entity.setRubroArticulo(rubroArticulo);
	 
				   List<DetalleReceta>detallesReceta = new ArrayList<DetalleReceta>();
					for(DetalleRecetaDto detalleRecetaDto : dto.getDetalles()) {
							DetalleReceta detalleReceta = new DetalleReceta();
							detalleReceta.setId(detalleReceta.getId());
							detalleReceta.setCantidad(detalleReceta.getCantidad());
							detalleReceta.getInsumo().setId(detalleRecetaDto.getInsumo().getId());
							detalleReceta.getInsumo().setDenominacion(detalleRecetaDto.getInsumo().getDenominacion());
							detalleReceta.getInsumo().setPrecioCompra(detalleRecetaDto.getInsumo().getPrecioCompra());
							detalleReceta.getInsumo().setStockActual(detalleRecetaDto.getInsumo().getStockActual());
							detalleReceta.getInsumo().setStockMinimo(detalleRecetaDto.getInsumo().getStockMinimo());
							detallesReceta.add(detalleReceta);
						}
						entity.setDetallesReceta(detallesReceta);

			 repository.save(entity);
			 dto.setId(entity.getId());
			 return dto;
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dto;
	}
	
	public void updateStock(long id, double cantidad, boolean esIngreso) throws Exception {
		Optional<Articulo> optionalEntity = repository.findById((long) id);
	    double stockActualizado=0;

		try {
		
			Articulo entity = optionalEntity.get();
			    entity.setId(id);
			    /*
			    if(esIngreso){ // si esIngreso es true es porque se esta ingresando stock, sino es porque se hizo un pedido y se esta restando al stock actual
					entity.setStockActual(entity.getStockActual() + cantidad);
			    }else{
					entity.setStockActual(entity.getStockActual() - cantidad);
			    }
	*/		 
			 repository.save(entity);
	 
		} catch (Exception e) {
			// TODO: handle exception
		}
		
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

