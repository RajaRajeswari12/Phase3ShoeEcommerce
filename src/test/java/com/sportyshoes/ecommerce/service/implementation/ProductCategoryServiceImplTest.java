
package com.sportyshoes.ecommerce.service.implementation;
import static org.junit.Assert.assertNotNull;

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
class ProductCategoryServiceImplTest {

	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductCategoryServiceImpl productCategoryServiceImpl;
	
	@Test
	void addNewProd() {
	
		
		ProductCategory productCategory = new ProductCategory();
		
		productCategory.setCategoryName("Boys1");
		
		productCategoryServiceImpl.saveProductCategory(productCategory);
		
		
//		assertNotNull(productCategoryServiceImpl.getProductCategory(productCategory.getCategory()));
		assertNotNull(productCategoryServiceImpl.getProductCategoryById(productCategory.getCategoryId()));
//		assert
		
		
	}

}
