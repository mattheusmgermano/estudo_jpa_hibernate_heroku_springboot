package com.mattheusestudando.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mattheusestudando.project.entities.Order;
import com.mattheusestudando.project.repositories.OrderRepository;

@Service  // cria um componente no spring e permite a injeção de dependência autowired
public class OrderService {

	@Autowired
	private OrderRepository repository;

	public List<Order> findAll() {
		return repository.findAll();
	}
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();  // retorna o objeto dentro do optional
	}
}