package com.sportyshoes.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.sportyshoes.ecommerce.Exception.ResourceNotFoundException;
import com.sportyshoes.ecommerce.models.Product;
import com.sportyshoes.ecommerce.models.ProductCategory;
import com.sportyshoes.ecommerce.repository.ProductCategoryRepository;
import com.sportyshoes.ecommerce.repository.ProductRepository;
import com.sportyshoes.ecommerce.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductRestController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductCategoryRepository productCategortRepository;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/product")
	public ResponseEntity<List<Product>> getAllProducts(){
		return ResponseEntity.ok().body(productRepository.findAll());
	}
	
	@GetMapping("/product/category")
	public ResponseEntity<List<ProductCategory>> getAllCategoryList(){
		return ResponseEntity.ok().body(productCategortRepository.findAll());
	}
	
//	@DeleteMapping(value="/deleteProductDetail")
	public ResponseEntity<Product> gotoDeleteProductDetailPage(@RequestParam("id") int id,
			@RequestParam("pageNo") String pageNo,Model model) throws ResourceNotFoundException 
	{
	
		
		productService.deleteById(id);
		return ResponseEntity.ok().build();

	}

	

}
