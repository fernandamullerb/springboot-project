package com.fernandamullerb.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernandamullerb.springproject.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	//O JpaRepository já possui os métodos save, findById, findAll etc.
}
