package com.sportyshoes.ecommerce.POJO;


import java.util.Date;

import javax.persistence.Temporal;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class PurchaseReportByDatePOJO {
	
	 @DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date purchaseDt;
	
	private int pageNo = 1;	

	public PurchaseReportByDatePOJO(Date purchaseDt, int pageNo) {
		super();
		this.purchaseDt = purchaseDt;
		this.pageNo = pageNo;
	}

	public PurchaseReportByDatePOJO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getPurchaseDt() {
		return purchaseDt;
	}

	public void setPurchaseDt(Date purchaseDt) {
		this.purchaseDt = purchaseDt;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	@Override
	public String toString() {
		return "PurchaseReportByDatePOJO [purchaseDt=" + purchaseDt + ", pageNo=" + pageNo + "]";
	}
	

}
