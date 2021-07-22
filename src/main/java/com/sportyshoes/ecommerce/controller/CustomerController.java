package com.sportyshoes.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.sportyshoes.ecommerce.POJO.CustomerNamePOJO;

import com.sportyshoes.ecommerce.models.Customer;
import com.sportyshoes.ecommerce.models.Product;
import com.sportyshoes.ecommerce.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/viewAllUser")
	public String viewAllUserListe(Model model) {
		return paginateUser(1,model);
	}
	
	@GetMapping("/user/{pageNo}")
	public String paginateUser(@PathVariable(value="pageNo") int pageNo,Model model) 
	{		
		int userCount = 8;
		Page<Customer> page = customerService.UserPagination(pageNo, userCount);
		List<Customer> listOfCustomer = page.getContent();		
		model.addAttribute("activePage",pageNo);
		model.addAttribute("totalPages",page.getTotalPages());
		model.addAttribute("listOfCustomer",listOfCustomer);
		return "viewCustomer";
	}
	
	@GetMapping("/viewUserByUserNm")
	public String gotoSearchUserPage(Model model) 
	{
		model.addAttribute("customerNamePOJO",new CustomerNamePOJO());
		return "searchByUser";
	}
	
	@GetMapping(value="/getUserDetail")
	public String gotoViewUserDetailPage(@RequestParam("userName") String userName,
			@RequestParam("pageNo") String PageNo,
			Model model) 
	{
		Customer customer = customerService.getCustomerByUserName(userName);	
		CustomerNamePOJO customerNamePOJO = new CustomerNamePOJO();
		customerNamePOJO.setUserName(userName);
		customerNamePOJO.setPageNo(1);
		model.addAttribute("customerNamePOJO",customerNamePOJO);
		model.addAttribute("customer",customer);
		model.addAttribute("pageNo",PageNo);
		return "displayUserDetail";
	}

}
