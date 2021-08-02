package com.mattheusestudando.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mattheusestudando.project.entities.Product;
import com.mattheusestudando.project.repositories.ProductRepository;

@Service  // cria um componente no spring e permite a injeção de dependência autowired
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public List<Product> findAll() {
		return repository.findAll();
	}
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();  // retorna o objeto dentro do optional
	}
}