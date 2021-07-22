package com.sportyshoes.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportyshoes.ecommerce.models.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {

//	Product getByProductId(int productId);
	
}
