package com.sportyshoes.ecommerce.service.implementation;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sportyshoes.ecommerce.models.Product;
import com.sportyshoes.ecommerce.models.ProductCategory;
import com.sportyshoes.ecommerce.repository.ProductRepository;
import com.sportyshoes.ecommerce.service.ProductCategoryService;
import com.sportyshoes.ecommerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductCategoryService productCategoryService;

	
	
	
	@Override
	public void addNewProduct(Product product) {
		
		product.setCategory(productCategoryService.saveProductCategory(product.getCategory()));
		productRepository.save(product);
	
	}




	@Override
	public Product getProductById(int productId) {
		
		return productRepository.getById(productId);
	}

	
	@Override
	public Page<Product> productPaginate(int pageNo, int productCount) {
		Pageable pageable = PageRequest.of(pageNo-1, productCount);
		return this.productRepository.findAll(pageable);
	}




	@Override
	public void deleteById(int productId) {
		productRepository.deleteById(productId);
		
	}






}
