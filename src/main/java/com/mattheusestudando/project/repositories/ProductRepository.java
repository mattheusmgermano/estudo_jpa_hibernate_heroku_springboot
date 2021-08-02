package com.mattheusestudando.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mattheusestudando.project.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	

}
