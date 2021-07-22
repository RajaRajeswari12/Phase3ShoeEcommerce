package com.sportyshoes.ecommerce.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Table(name="Product_Category")
public class ProductCategory {

	@Id
	@GeneratedValue
	private int categoryId;
	
	@Column(unique = true)
	private String categoryName;

	public ProductCategory() {
		super();
		
		// TODO Auto-generated constructor stub
	}

	public ProductCategory(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	
	public int getCategoryId() {
		return categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public boolean isSelected(Integer Id){
        if (Id != null) {
            return Id.equals(categoryId);
        }
        return false;
    } 

	@Override
	public String toString() {
		return "ProductCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	
	
	
	
	
	
}
