package com.sportyshoes.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportyshoes.ecommerce.models.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer>{
	
	ProductCategory getByCategoryName(String categoryName);

}
