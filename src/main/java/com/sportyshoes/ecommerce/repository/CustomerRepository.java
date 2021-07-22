package com.sportyshoes.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportyshoes.ecommerce.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	
	Customer getCustomerByUserName(String userName);
}
