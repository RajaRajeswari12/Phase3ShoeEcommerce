package com.sportyshoes.ecommerce.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sportyshoes.ecommerce.models.Customer;
import com.sportyshoes.ecommerce.repository.CustomerRepository;
import com.sportyshoes.ecommerce.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Page<Customer> UserPagination(int pageNo, int userCount) {
		Pageable pageable = PageRequest.of(pageNo-1, userCount);
		return this.customerRepository.findAll(pageable);
	}

	@Override
	public Customer getCustomerByUserName(String userName) {
		// TODO Auto-generated method stub
		return customerRepository.getCustomerByUserName(userName);
	}

}
