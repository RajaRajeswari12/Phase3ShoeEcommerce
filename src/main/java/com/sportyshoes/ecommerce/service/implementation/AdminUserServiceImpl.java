package com.sportyshoes.ecommerce.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.sportyshoes.ecommerce.models.AdminUser;
import com.sportyshoes.ecommerce.repository.AdminUserRepository;
import com.sportyshoes.ecommerce.service.AdminUserService;

@Service
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired
	private AdminUserRepository adminUserRepository;

	@Override
	public void saveAdminUser(AdminUser adminUser) {
		adminUserRepository.save(adminUser);

	}

	@Override
	public AdminUser findByAdminUserName(String adminUserName) {

		return adminUserRepository.findByAdminUserName(adminUserName);
	}

	@Override
	public void authenticateAdminUser(AdminUser adminUser, BindingResult result) {
		AdminUser getValidAdminUser = adminUserRepository.findByAdminUserName(adminUser.getAdminUserName());
		String errorMessage = null;

		if(getValidAdminUser != null) {
			if(!getValidAdminUser.getAdminPassword().equals(adminUser.getAdminPassword())){
				errorMessage = "Invalid password. Try Again with correct credentials.";
			}
		}else {
			errorMessage = "Username doesn't exist.";			
		}
		if(errorMessage != null) {
			ObjectError error = new ObjectError("loginError",errorMessage);
			result.addError(error);
		}


	}



}
