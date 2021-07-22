package com.sportyshoes.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportyshoes.ecommerce.models.AdminUser;

public interface AdminUserRepository extends JpaRepository<AdminUser, Integer> {
	
	AdminUser findByAdminUserName(String username);

}
