package com.sportyshoes.ecommerce.service.implementation;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.ecommerce.models.ProductCategory;
import com.sportyshoes.ecommerce.repository.ProductCategoryRepository;
import com.sportyshoes.ecommerce.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{

	public Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Override
	public Optional<ProductCategory> getProductCategory(String category) {

		return Optional.ofNullable(productCategoryRepository.getByCategoryName(category));
	}

	@Override
	public ProductCategory saveProductCategory(ProductCategory productCategory) {
		
		Optional<ProductCategory> optional = getProductCategory(productCategory.getCategoryName());
		if(!optional.isPresent()) {		
			productCategoryRepository.save(productCategory);
		}else {
			productCategory = optional.get();			
		}
		
		return productCategory;

	}

	@Override
	public ProductCategory getProductCategoryById(int categoryId) {

		return productCategoryRepository.getById(categoryId);
	}

	@Override
	public List<ProductCategory> getAllProductCategory() {
		
		return productCategoryRepository.findAll();
	}

}
