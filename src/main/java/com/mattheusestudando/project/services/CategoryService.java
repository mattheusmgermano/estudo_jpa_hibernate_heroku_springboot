package com.mattheusestudando.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mattheusestudando.project.entities.Category;
import com.mattheusestudando.project.repositories.CategoryRepository;

@Service  // cria um componente no spring e permite a injeção de dependência autowired
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	public List<Category> findAll() {
		return repository.findAll();
	}
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();  // retorna o objeto dentro do optional
	}
}