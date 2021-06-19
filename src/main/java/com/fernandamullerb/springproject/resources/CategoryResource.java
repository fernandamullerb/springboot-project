package com.fernandamullerb.springproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernandamullerb.springproject.entities.Category;
import com.fernandamullerb.springproject.repositories.CategoryRepository;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired //injeção de dependência no Spring Boot (instancia o objeto CategoryRepository).
	private CategoryRepository categoryRepository;
	
	@GetMapping //resposta à requisição GET.
	public ResponseEntity<List<Category>> findAll() { //retorna uma lista com todas as categorias.
		List<Category> list = categoryRepository.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) { //retorna uma categoria a partir do id.
		Category cat = categoryRepository.findById(id);
		return ResponseEntity.ok().body(cat);
	}	
}
