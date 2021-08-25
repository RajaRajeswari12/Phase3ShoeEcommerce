package com.sportyshoes.ecommerce.models;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne(targetEntity= ProductCategory.class,cascade = CascadeType.DETACH)
	@JoinColumn(name="categoryId",referencedColumnName = "categoryId")
	private ProductCategory category;
	
	private String productName;
	
	private int productSize;
	
	private float productPrice;
	
	 @DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date mfgDate;
	
	private int quantity;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Product(ProductCategory category, String productName, int productSize, float productPrice, Date mfgDate,
			int quantity) {
		super();
		this.category = category;
		this.productName = productName;
		this.productSize = productSize;
		this.productPrice = productPrice;
		this.mfgDate = mfgDate;
		this.quantity = quantity;
	}





	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Date getMfgDate() {
		return mfgDate;
	}


	/*
	 * public void setMfgDate(String mfgDate) throws ParseException { Date
	 * convertedDate=new SimpleDateFormat("dd-mm-yyyy").parse(mfgDate); // long
	 * convertedDate = Date.parse(mfgDate); this.mfgDate = convertedDate; }
	 */
	
	
	public void setMfgDate(Date mfgDate) {
		this.mfgDate = mfgDate;
	}
	

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductSize() {
		return productSize;
	}

	public void setProductSize(int productSize) {
		this.productSize = productSize;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", productName=" + productName + ", productSize="
				+ productSize + ", productPrice=" + productPrice + ", mfgDate=" + mfgDate + ", quantity=" + quantity
				+ "]";
	}

	
	
	
}
