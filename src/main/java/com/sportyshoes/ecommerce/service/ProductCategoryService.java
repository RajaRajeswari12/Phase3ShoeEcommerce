package com.sportyshoes.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.sportyshoes.ecommerce.models.ProductCategory;

@Transactional 
public interface ProductCategoryService {
	
	List<ProductCategory> getAllProductCategory();
	
	Optional<ProductCategory> getProductCategory(String category);
	
	ProductCategory getProductCategoryById(int categoryId);
	
	ProductCategory saveProductCategory(ProductCategory productCategory);

}
