package com.sportyshoes.app.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.sportyshoes.app.model.Product;

public interface SportyShoesProductRepository extends CrudRepository<Product, Integer> {
	
	List<Product> findBySeason(String season);
	
	List<Product> findByBrand(String brand);
	
	List<Product> findByCategory(String category);
	
	List<Product> findByColor(String color);
	
	List<Product> findByCreatedDate(String createdDate);
	
	List<Product> findByCreatedDateAndCategory(String createdDate, String category);

	List<Product> findAll(Sort price);
	
	

}
