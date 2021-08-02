package com.mattheusestudando.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mattheusestudando.project.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	

}
