package com.crud.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.user.entities.UserEntity;
import com.crud.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	
	public void createUser(UserEntity userEntity) {
		
		 userRepository.save(userEntity);
	}
	
	public UserEntity getById(Long id) {
		
		UserEntity entity = userRepository.findById(id).get();
		
		if (entity == null) {
			throw new RuntimeException("User Does Not Exist");
		}
		
		return entity;
	}
	
	public void updateUser(Long id, UserEntity userEntity) {
		
		UserEntity entity = userRepository.findById(id).get();
		
		if (entity == null) {
			throw new RuntimeException("User Does Not Exist");
		}
		
		entity.setUserName(userEntity.getUserName());
		entity.setUserEmail(userEntity.getUserEmail());
		
		userRepository.save(entity);
	}
	
	public List<UserEntity> getAllUsers(){
		List<UserEntity> entities = userRepository.findAll();
		
		return entities;
	}
	
	public void deleteUser(Long id) {
		
		UserEntity entity = userRepository.findById(id).get();
		
		if (entity == null) {
			throw new RuntimeException("User Does Not Exist");
		}
		
		userRepository.delete(entity);
	}
	
}
