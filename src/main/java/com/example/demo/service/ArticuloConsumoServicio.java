package com.example.demo.service;


import org.springframework.stereotype.Service;
import com.example.demo.entity.ArticuloConsumo;
import com.example.demo.repository.ArticuloConsumoRepository;
import com.example.demo.dtos.ArticuloConsumoDto;

@Service
public class ArticuloConsumoServicio {


	ArticuloConsumoRepository repository;

	public ArticuloConsumoServicio(ArticuloConsumoRepository repository) {
		this.repository = repository;
	}
	
	public List<ArticuloConsumoDto> findAll() throws Exception {
		
		List<ArticuloConsumo>entities = repository.findAll();
		List<MutantDto>dtos = new ArrayList<MutantDto>();
		try {
			
			for(ArticuloConsumo i : entities) {
				MutantDto dto = new MutantDto();
				dto.setId(i.getId());
				dto.setIndividuo(i.getIndividuo());
				dto.setAdn(i.getAdn());
				dto.setEstado(i.getEstado());
				dtos.add(dto);
			}
			
			return dtos;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public MutantDto findById(int id) throws Exception{
		
		Optional<ArticuloConsumo>entityOptional = repository.findById(id);
		
		MutantDto dto = new MutantDto();
		
		try {
			 ArticuloConsumo articuloConsumo = entityOptional.get();
			 dto.setId(articuloConsumo.getId());
			 dto.setIndividuo(articuloConsumo.getArticuloConsumo());
			 dto.setAdn(articuloConsumo.getAdn());
			 dto.setEstado(articuloConsumo.getEstado());
		} catch (Exception e) {
			throw new Exception();
		}
		
		return dto;
	}
	
		
    public MutantDto save(MutantDto dto, boolean estado) throws Exception {
		
		Mutant articuloConsumo = new Mutant();
		
		articuloConsumo.setIndividuo(dto.getIndividuo());
		articuloConsumo.setAdn(dto.getAdn());
		if(estado) {
			articuloConsumo.setEstado("mutante");
		}else {
			mutante.setEstado("humano");
		}
		
		try {
			mutante = repository.save(mutante);
			dto.setId(mutante.getId());
			dto.setEstado(mutante.getEstado());
			return dto;
		} catch (Exception e) {
			throw new Exception();	
		}
		
			
	}
	
	public MutantDto update(int id, MutantDto dto, boolean estado) throws Exception {
		Optional<Mutant> mutante = repository.findById(id);
		
		try {
			 Mutant entity = mutante.get();
			 entity.setId(id);
			 entity.setIndividuo(dto.getIndividuo());
			 entity.setAdn(dto.getAdn());
			 if(estado) {
				 entity.setEstado("mutante");
			 }else {
				 entity.setEstado("humano");
			 }
			 
			 repository.save(entity);
			 dto.setId(entity.getId());
			 dto.setEstado(entity.getEstado());
			 return dto;
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dto;
	}
			
	public boolean delete(int id) throws Exception {
		try {
			if(repository.existsById(id)) {
				repository.deleteById(id);
				return true;
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception();
		}
		
	}
	
	
	}
	
	
}

