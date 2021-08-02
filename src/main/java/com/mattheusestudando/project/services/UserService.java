package com.mattheusestudando.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mattheusestudando.project.entities.User;
import com.mattheusestudando.project.repositories.UserRepository;
import com.mattheusestudando.project.services.exceptions.DatabaseException;
import com.mattheusestudando.project.services.exceptions.ResourceNotFoundException;

@Service  // cria um componente no spring e permite a injeção de dependência autowired
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
//		return obj.get();  // retorna o objeto dentro do optional
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	public User update(Long id, User obj) {
		User entity = repository.getOne(id); //getOne só prepara um obj para depois salvar no banco de dados, enquanto findById retorna o obj em si.
		updateData(entity, obj);
		return repository.save(entity);
		
	}
	private void updateData(User entity, User obj) {
		// TODO Auto-generated method stub
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}