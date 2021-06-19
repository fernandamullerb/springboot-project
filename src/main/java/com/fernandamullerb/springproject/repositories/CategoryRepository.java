package com.fernandamullerb.springproject.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fernandamullerb.springproject.entities.Category;

@Component //necessário para a injeção de dependência na classe CategoryResource.
public class CategoryRepository {

	private Map<Long, Category> map = new HashMap<>(); //coleção de chave-valor.
	
	public void save(Category obj) { //salva um objeto do tipo categoria.
		map.put(obj.getId(), obj);
	}

	public Category findById(Long id) { //retorna uma categoria a partir do id.
		return map.get(id);
	}
	
	public List<Category> findAll() { //retorna uma lista com todas as categorias.
		return new ArrayList<Category>(map.values());
	}
}
