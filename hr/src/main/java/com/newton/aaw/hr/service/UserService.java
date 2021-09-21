package com.newton.aaw.hr.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.newton.aaw.hr.domain.entity.User;
import com.newton.aaw.hr.domain.repository.UserRepository;
import com.newton.aaw.hr.exception.NotFoundException;

@Service
public class UserService {

	//	armazenar os objetos na memória
	//	private Map<String, User> users = new HashMap<String, User>();
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	// C - CREATE
	public User create(User u) {
		u.setCreateAt(LocalDateTime.now());
		u.setModifiedAt(LocalDateTime.now());
		
		userRepository.save(u);
		
		return u;
	}
	
	// R - READ
	public User get(String id) {
		var user = userRepository.findById(id);
		
		if (user.isEmpty()) {
			throw new NotFoundException("User with ID " + id + " not found");
		}
		return user.get();
	}
	
	// R - READ ALL
	public List<User> getAll(){
		return userRepository.findAll();
	}
	
	// U - UPDATE
	public User update(String id, User u) {
		var existing = get(id); //recuperar para validar se existe
		
		existing.setName(u.getName());
		existing.setPassword(u.getPassword());
		existing.setEmail(u.getEmail());
		existing.setMobile(u.getMobile());
		existing.setModifiedAt(LocalDateTime.now());
		
		userRepository.save(existing);
		
		return existing;
	}
	
	// D - DELETE
	public void delete(String id) {
		get(id); //recuperar para validar se existe
		
		userRepository.deleteById(id);
	}

}
