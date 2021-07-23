package com.sportyshoes.ecommerce.POJO;

import org.springframework.stereotype.Component;

@Component
public class GetProductIdPOJO {

	private int id;
	
	private int pageNo = 1;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = 1;
	}



	public GetProductIdPOJO(int id, int pageNo) {
		super();
		this.id = id;
		this.pageNo = pageNo;
	}

	public GetProductIdPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "GetProductIdPOJO [productId=" + id+ ", pageNo=" + pageNo + "]";
	}
	
	
	
}
