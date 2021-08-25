package com.sportyshoes.ecommerce.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sportyshoes.ecommerce.POJO.GetProductIdPOJO;
import com.sportyshoes.ecommerce.models.Product;
import com.sportyshoes.ecommerce.service.ProductService;



@RestController
public class ProductController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductService productService;

	@Autowired
	private GetProductIdPOJO getProductIdPOJO;
	

	private Product product;


	@GetMapping("/viewAllProducts")
	public ModelAndView viewAllProductsPage(Model model) {
		return paginatedProduct(1,model);
	}

	@GetMapping("/product/{pageNo}")
	public ModelAndView paginatedProduct(@PathVariable(value="pageNo") int pageNo,Model model) 
	{		
		int productCount = 8;
		ModelAndView paginateProduct = new ModelAndView();
		Page<Product> page = productService.productPaginate(pageNo, productCount);
		List<Product> listOfProducts = page.getContent();		
		model.addAttribute("activePage",pageNo);
		model.addAttribute("totalPages",page.getTotalPages());
		model.addAttribute("totalRecords",page.getTotalElements());
		model.addAttribute("listOfProducts",listOfProducts);
		paginateProduct.setViewName("viewProduct");
		paginateProduct.addObject(model);
		return paginateProduct;
	}


	@PostMapping(value = "/saveProduct")
	public ModelAndView addNewProductPage(Model model) 
	{
		ModelAndView newProduct = new ModelAndView();
		model.addAttribute("product",new Product());
		model.addAttribute("pageNo",1);
		newProduct.addObject(model);
		newProduct.setViewName("addProduct");
		return newProduct;
	}

	@PostMapping(value = "/saveOrUpdateProduct")
	public ModelAndView saveProductDetails(@ModelAttribute("product") Product product,@RequestParam("pageNo") String pageNo) 
	{
		ModelAndView saveProduct = new ModelAndView();
		productService.addNewProduct(product);
//		newProduct.addObject(model);
		saveProduct.setViewName("redirect:/product/"+pageNo);
		return saveProduct;
	}


	@PutMapping(value="/updateProductDetail")
	public ModelAndView gotoUpdateProductDetailPage(@RequestParam("id") int id,
			@RequestParam("pageNo") String pageNo,Model model) 
	{
		ModelAndView updateProduct = new ModelAndView();
		product = productService.getProductById(id);	
		boolean productNotFound = false;
		if(product == null) {
			productNotFound = true;
		}
		model.addAttribute("productNotFound",productNotFound);
		model.addAttribute("product",product);
		model.addAttribute("pageNo",pageNo);
		updateProduct.addObject(model);
		updateProduct.setViewName("updateProduct");
		return updateProduct;
	}

	@DeleteMapping(value="/deleteProductDetail")
	public ModelAndView gotoDeleteProductDetailPage(@RequestParam("id") int id,
			@RequestParam("pageNo") String pageNo,Model model) 
	{
		ModelAndView deleteProduct = new ModelAndView();
		product = productService.getProductById(id);	
		logger.info("$$$$$$$$$$$$ Product"+product + " "+ id);
		if(product != null) {
			productService.deleteById(id);
			deleteProduct.setViewName("redirect:/product/"+pageNo);
			return deleteProduct;
			
		}else {
			model.addAttribute("id",id);
			return gotoDeleteProductPage(model,true);
		}
	}

	@DeleteMapping("/deleteProduct")
	public ModelAndView gotoDeleteProductPage(Model model,boolean productNotFound) 
	{
		ModelAndView deleteProduct = new ModelAndView();
		if(productNotFound) {
			
			Integer id = (Integer) model.getAttribute("id");
			logger.info("$$$$$$$$$$$$ "+id);
			getProductIdPOJO.setId(id);
		}
		model.addAttribute("productNotFound",productNotFound);
		model.addAttribute("productIdPOJO",getProductIdPOJO);
		deleteProduct.addObject(model);
		deleteProduct.setViewName("deleteProduct");
		return deleteProduct;
	}


	@PutMapping("/updateProduct")
	public ModelAndView gotoUpdateProductPage(Model model) 
	{
		ModelAndView updateProductPage = new ModelAndView();
		model.addAttribute("productIdPOJO",getProductIdPOJO);
		updateProductPage.addObject(model);
		updateProductPage.setViewName("updateProductPage");
		return updateProductPage;
	}
}
