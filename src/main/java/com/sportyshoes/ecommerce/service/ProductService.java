package com.sportyshoes.ecommerce.service;



import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import com.sportyshoes.ecommerce.models.Product;

@Transactional 
public interface ProductService {
	
	Product getProductById(int productId);
	
	void addNewProduct(Product product);
	Page<Product> productPaginate(int pageNo,int productCount);

	void deleteById(int productId);

}
