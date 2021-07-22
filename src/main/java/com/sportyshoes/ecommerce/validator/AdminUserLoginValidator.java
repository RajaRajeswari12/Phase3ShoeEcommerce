package com.sportyshoes.ecommerce.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sportyshoes.ecommerce.models.AdminUser;
import com.sportyshoes.ecommerce.service.AdminUserService;

public class AdminUserLoginValidator implements Validator{
	
	@Autowired
	private AdminUserService adminUserService;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return AdminUser.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

}
