package com.mattheusestudando.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mattheusestudando.project.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	

}
