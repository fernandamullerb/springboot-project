package com.fernandamullerb.springproject.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fernandamullerb.springproject.entities.Product;

@Component //necessário para a injeção de dependência na classe ProductResource.
public class ProductRepository {

	private Map<Long, Product> map = new HashMap<>(); //coleção de chave-valor.
	
	public void save(Product obj) { //salva um objeto do tipo produto.
		map.put(obj.getId(), obj);
	}

	public Product findById(Long id) { //retorna um produto a partir do id.
		return map.get(id);
	}
	
	public List<Product> findAll() { //retorna uma lista com todos os produtos.
		return new ArrayList<Product>(map.values());
	}
}
