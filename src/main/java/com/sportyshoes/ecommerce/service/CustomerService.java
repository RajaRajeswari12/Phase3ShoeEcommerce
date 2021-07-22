package com.sportyshoes.ecommerce.service;

import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import com.sportyshoes.ecommerce.models.Customer;
import com.sportyshoes.ecommerce.models.Product;

@Transactional
public interface CustomerService {
	
	Page<Customer> UserPagination(int pageNo,int userCount);
	Customer getCustomerByUserName(String userName);

}
