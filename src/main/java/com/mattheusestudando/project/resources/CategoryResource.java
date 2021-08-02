package com.mattheusestudando.project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mattheusestudando.project.entities.Category;
import com.mattheusestudando.project.services.CategoryService;

@RestController
@RequestMapping(value="/category")
public class CategoryResource {
	
	@Autowired
	private CategoryService catService;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = catService.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){   //Ao add o @pathvariable o id passa a ser o mesmo da rota
		Category obj = catService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
