package com.fernandamullerb.springproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernandamullerb.springproject.entities.Product;
import com.fernandamullerb.springproject.repositories.ProductRepository;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired //injeção de dependência no Spring Boot (instancia o objeto ProductRepository).
	private ProductRepository categoryRepository;
	
	@GetMapping //resposta à requisição GET.
	public ResponseEntity<List<Product>> findAll() { //retorna uma lista com todos os produtos.
		List<Product> list = categoryRepository.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) { //retorna um produto a partir do id.
		Product cat = categoryRepository.findById(id);
		return ResponseEntity.ok().body(cat);
	}	
}
