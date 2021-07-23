package com.sportyshoes.ecommerce.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sportyshoes.ecommerce.POJO.GetProductIdPOJO;
import com.sportyshoes.ecommerce.models.Product;
import com.sportyshoes.ecommerce.service.ProductService;



@Controller
public class ProductController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductService productService;

	@Autowired
	private GetProductIdPOJO getProductIdPOJO;
	

	private Product product;


	@GetMapping("/viewAllProducts")
	public String viewAllProductsPage(Model model) {
		return paginatedProduct(1,model);
	}

	@GetMapping("/product/{pageNo}")
	public String paginatedProduct(@PathVariable(value="pageNo") int pageNo,Model model) 
	{		
		int productCount = 8;
		Page<Product> page = productService.productPaginate(pageNo, productCount);
		List<Product> listOfProducts = page.getContent();		
		model.addAttribute("activePage",pageNo);
		model.addAttribute("totalPages",page.getTotalPages());
		model.addAttribute("totalRecords",page.getTotalElements());
		model.addAttribute("listOfProducts",listOfProducts);
		return "viewProduct";
	}


	@RequestMapping(value = "/saveProduct",method=RequestMethod.GET)
	public String addNewProductPage(Model model) 
	{
		model.addAttribute("product",new Product());
		model.addAttribute("pageNo",1);
		return "addProduct";
	}

	@PostMapping(value = "/saveOrUpdateProduct")
	public String saveProductDetails(@ModelAttribute("product") Product product,@RequestParam("pageNo") String pageNo) 
	{
		productService.addNewProduct(product);
		return "redirect:/product/"+pageNo;
	}


	@GetMapping(value="/updateProductDetail")
	public String gotoUpdateProductDetailPage(@RequestParam("id") int id,
			@RequestParam("pageNo") String pageNo,Model model) 
	{
		product = productService.getProductById(id);	
		boolean productNotFound = false;
		if(product == null) {
			productNotFound = true;
		}
		model.addAttribute("productNotFound",productNotFound);
		model.addAttribute("product",product);
		model.addAttribute("pageNo",pageNo);
		return "updateProduct";
	}

	@GetMapping(value="/deleteProductDetail")
	public String gotoDeleteProductDetailPage(@RequestParam("id") int id,
			@RequestParam("pageNo") String pageNo,Model model) 
	{
		product = productService.getProductById(id);	
		logger.info("$$$$$$$$$$$$ Product"+product + " "+ id);
		if(product != null) {
			productService.deleteById(id);		
			return "redirect:/product/"+pageNo;
			
		}else {
			model.addAttribute("id",id);
			return gotoDeleteProductPage(model,true);
		}
	}

	@GetMapping("/deleteProduct")
	public String gotoDeleteProductPage(Model model,boolean productNotFound) 
	{
		if(productNotFound) {
			
			Integer id = (Integer) model.getAttribute("id");
			logger.info("$$$$$$$$$$$$ "+id);
			getProductIdPOJO.setId(id);
		}
		model.addAttribute("productNotFound",productNotFound);
		model.addAttribute("productIdPOJO",getProductIdPOJO);
		return "deleteProduct";
	}


	@GetMapping("/updateProduct")
	public String gotoUpdateProductPage(Model model) 
	{

		model.addAttribute("productIdPOJO",getProductIdPOJO);
		return "updateProductPage";
	}
}
