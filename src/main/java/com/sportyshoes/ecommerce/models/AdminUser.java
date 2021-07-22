package com.sportyshoes.ecommerce.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Id;

@Entity
@Table(name="Admin_User")
public class AdminUser {

	@Id
	@GeneratedValue
	private int adminId;
	
	@Column(unique = true)
	private String adminUserName;
	
	private String adminPassword;
	
	@Transient
	 private String adminPasswordConfirm;
	
	@Transient
	private String validUser;

	
	
	public AdminUser() {
		super();
	}

	

	public AdminUser(String adminUserName, String adminPassword, String adminPasswordConfirm) {
		super();
		this.adminUserName = adminUserName;
		this.adminPassword = adminPassword;
		this.adminPasswordConfirm = adminPasswordConfirm;
	}



	public int getAdminId() {
		return adminId;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	
	@Transient
	public String getAdminPasswordConfirm() {
		return adminPasswordConfirm;
	}



	public void setAdminPasswordConfirm(String adminPasswordConfirm) {
		this.adminPasswordConfirm = adminPasswordConfirm;
	}



	@Override
	public String toString() {
		return "AdminUser [adminId=" + adminId + ", adminUserName=" + adminUserName + ", adminPassword=" + adminPassword
				+ ", adminPasswordConfirm=" + adminPasswordConfirm + "]";
	}

}
