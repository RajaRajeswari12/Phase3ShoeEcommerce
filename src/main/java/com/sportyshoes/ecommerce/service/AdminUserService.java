package com.sportyshoes.ecommerce.service;

import org.springframework.validation.BindingResult;

import com.sportyshoes.ecommerce.models.AdminUser;

public interface AdminUserService {

	
	void saveAdminUser(AdminUser adminUser);
	
	AdminUser findByAdminUserName(String adminUserName);
	
	void authenticateAdminUser(AdminUser adminUser,BindingResult result);
}
