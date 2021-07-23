package com.sportyshoes.ecommerce.POJO;

import org.springframework.stereotype.Component;

@Component
public class CustomerNamePOJO {
	
	private String userName;
	
	private int pageNo = 1;
	
	

	public CustomerNamePOJO(String userName, int pageNo) {
		super();
		this.userName = userName;
		this.pageNo = pageNo;
	}

	
	public CustomerNamePOJO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	@Override
	public String toString() {
		return "CustomerNamePOJO [userName=" + userName + ", pageNo=" + pageNo + "]";
	}
	
	

}
