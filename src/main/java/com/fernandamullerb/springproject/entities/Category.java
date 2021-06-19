package com.fernandamullerb.springproject.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity //entidade gerenciada pelo JPA.
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id //sinaliza qual será o ID no DB.
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement.
	private Long id;
	private String name;
	
	@OneToMany(mappedBy = "category") //um para muitos (nome do atributo).
	@JsonIgnore //evita a serialização da lista de produtos da categoria.
	private List<Product> products = new ArrayList<>();
	
	public Category() {
	}

	public Category(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}

	public List<Product> getProducts() {
		return products;
	}
}
