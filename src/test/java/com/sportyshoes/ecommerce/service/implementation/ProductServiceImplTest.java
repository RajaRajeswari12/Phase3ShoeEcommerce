
package com.sportyshoes.ecommerce.service.implementation;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sportyshoes.ecommerce.EcommerceApplication;
import com.sportyshoes.ecommerce.models.Product;
import com.sportyshoes.ecommerce.models.ProductCategory;

@RunWith(SpringRunner.class)

@SpringBootTest(classes=EcommerceApplication.class) 
class ProductServiceImplTest {

	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@Test
	void addNewProd() {
		Product product = new Product();
		
		product.setProductName("Canvas Chappel");
		product.setProductSize(13);
		product.setProductPrice(400.0f);
		
		ProductCategory productCategory = new ProductCategory();
		
		productCategory.setCategoryName("Kids123");
		
		product.setCategory(productCategory);
		
		logger.info("Before the METHODDDDDDDDDDDDDDDDDD");
		
		productServiceImpl.addNewProduct(product);
		
//		assert
		
		
	}

}
