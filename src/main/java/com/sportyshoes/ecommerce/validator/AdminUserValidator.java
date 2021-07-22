package com.sportyshoes.ecommerce.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sportyshoes.ecommerce.models.AdminUser;
import com.sportyshoes.ecommerce.service.AdminUserService;

@Component
public class AdminUserValidator implements Validator{

	@Autowired
	private AdminUserService adminUserService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return AdminUser.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		AdminUser adminUser = (AdminUser) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "adminUserName", "NotEmpty");
		
		if(adminUser.getAdminUserName().length() < 5 || adminUser.getAdminUserName().length() > 20) {
			errors.rejectValue("adminUserName", "Size");
		}
		
		if(adminUserService.findByAdminUserName(adminUser.getAdminUserName())!=null) {
			errors.rejectValue("adminUserName", "Duplicate.adminUser.adminUserName");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"adminPassword" , "NotEmpty");
		
		if(adminUser.getAdminPassword().length() < 8 || adminUser.getAdminPassword().length() > 24) {
			errors.rejectValue("adminPassword", "Size.adminUser.adminPassword");
		}
		
		if(!adminUser.getAdminPassword().equals(adminUser.getAdminPasswordConfirm())) {
			errors.rejectValue("adminPasswordConfirm", "Diff.adminUser.adminPasswordConfirm");
		}
		
	}

}
