package com.sportyshoes.ecommerce.models;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries(value = {
		  @NamedQuery(name = "PurchaseReport.findByCategory", query = "select pr from PurchaseReport pr where pr.product.category.categoryId = ?1") ,

		  @NamedQuery(name = "PurchaseReport.findByDate", query = "select pr from PurchaseReport pr where pr.purchasedDate = ?1") })
public class PurchaseReport {

	
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	private Customer customer;
	
	@ManyToOne
	private Product product;
	
	private int purchasedQuantity;
	
	@Temporal(TemporalType.DATE)
	private Date purchasedDate;
 
	public PurchaseReport() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PurchaseReport(Customer customer, Product product, int purchasedQuantity, Date purchasedDate) {
		super();
		this.customer = customer;
		this.product = product;
		this.purchasedQuantity = purchasedQuantity;
		this.purchasedDate = purchasedDate;
	}


	public int getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Product getProduct() {
		return product;
	}

	public int getPurchasedQuantity() {
		return purchasedQuantity;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setPurchasedQuantity(int purchasedQuantity) {
		this.purchasedQuantity = purchasedQuantity;
	}
	
	public Date getPurchasedDate() {
		return purchasedDate;
	}

	public void setPurchasedDate(Date purchasedDate) {
		this.purchasedDate = purchasedDate;
	}


	@Override
	public String toString() {
		return "PurchaseReport [id=" + id + ", customer=" + customer + ", product=" + product + ", purchasedQuantity="
				+ purchasedQuantity + ", purchasedDate=" + purchasedDate + "]";
	}
	
	
	
	
}
