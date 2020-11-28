package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dtos.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.SecurityRepository;

@Service
public class SecurityService {
	
		
		SecurityRepository repository;

		public SecurityService(SecurityRepository repository) {
			this.repository = repository;
		}
		
		public List<UserDto> findAll() throws Exception {
			
			List<User>entities = repository.findAll();
			List<UserDto>dtos = new ArrayList<UserDto>();
			try {
				
				for(User entity : entities) {
					UserDto dto = new UserDto();
					dto.setRole(entity.getRole());
					dto.setUid(entity.getUid());
					dto.setEmail(entity.getEmail());
					dtos.add(dto);
				}
				
				return dtos;
				
			} catch (Exception e) {
				throw new Exception();
			}
			
		}
		
		public UserDto findById(long id) throws Exception {
				
			Optional<User>entityOptional = repository.findById((long) id);
			
			UserDto dto = new UserDto();
			
			try {
				 User entity = entityOptional.get();
				
				 dto.setRole(entity.getRole());
				 dto.setUid(entity.getUid());
				 dto.setEmail(entity.getEmail());
				 
			} catch (Exception e) {
				throw new Exception();
			}
			
			return dto;
				
		}
		
		public UserDto findByUid(long uid) throws Exception {
			
				
			UserDto dto = new UserDto();
			
			try {
				 
				 User entity = repository.findByUid(uid);
				 dto.setRole(entity.getRole());
				 dto.setUid(entity.getUid());
				 
			} catch (Exception e) {
				System.out.print("no se encontró el usuario");
				throw new Exception();
				
			}
			
			return dto;
				
		}
		
		 public UserDto save(UserDto dto, boolean estado) throws Exception {
				
				User entity = new User();
				entity.setUid(dto.getUid());
				entity.setRole(dto.getRole());
				entity.setEmail(dto.getEmail());
				
				try {
					entity = repository.save(entity);
					return dto;
				} catch (Exception e) {
					throw new Exception();	
				}
				
					
		}
		 
		 public UserDto update(long uid, UserDto dto, boolean estado) throws Exception {
				
				
				try {
					User entity = repository.findByUid(uid);
					 entity.setUid(dto.getUid());
					 entity.setRole(dto.getRole());		
					 entity.setEmail(dto.getEmail());
						
					 repository.save(entity);
					 
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

}
