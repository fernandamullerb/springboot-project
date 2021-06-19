package com.fernandamullerb.springproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fernandamullerb.springproject.entities.Category;
import com.fernandamullerb.springproject.repositories.CategoryRepository;

@SpringBootApplication
public class SpringProjectApplication implements CommandLineRunner{

	@Autowired //injeção de dependência no Spring Boot (instancia o objeto CategoryRepository).
	private CategoryRepository categoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception { //instancia as categorias no startup da aplicação
		Category cat1 = new Category(1L, "Electronics");
		Category cat2 = new Category(2L, "Books");
		
		categoryRepository.save(cat1);
		categoryRepository.save(cat2);
	}

}
