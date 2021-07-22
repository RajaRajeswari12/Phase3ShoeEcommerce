package com.sportyshoes.ecommerce.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(unique = true)
	private String userName;
	
	private String password;
	
	private String email;
	
	private String customerName;
	
	private String Address;
	
	private String phoneNo;

	public Customer(String userName, String password, String email, String customerName, String address,
			String phoneNo) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.customerName = customerName;
		Address = address;
		this.phoneNo = phoneNo;
	}

	public Customer() {
		super();
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", customerName=" + customerName + ", Address=" + Address + ", phoneNo=" + phoneNo + "]";
	}
	
	 
	
	
}
