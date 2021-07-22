
package com.sportyshoes.ecommerce.repository;

import static org.junit.Assert.assertNotNull; import static
org.junit.Assert.assertNull; import static
org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test; import org.junit.runner.RunWith; import
org.slf4j.Logger; import org.slf4j.LoggerFactory; import
org.springframework.beans.factory.annotation.Autowired; import
org.springframework.boot.test.context.SpringBootTest; import
org.springframework.test.annotation.DirtiesContext; import
org.springframework.test.context.junit4.SpringRunner;

import com.sportyshoes.ecommerce.EcommerceApplication; import
com.sportyshoes.ecommerce.models.AdminUser; import
com.sportyshoes.ecommerce.repository.AdminUserRepository;

@RunWith(SpringRunner.class)

@SpringBootTest(classes=EcommerceApplication.class) class
AdminUserRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	AdminUserRepository repository;

	@Test 
	void createAdminUser() { AdminUser admin = new AdminUser();
	admin.setAdminUserName("Raji"); 
	admin.setAdminPassword("Raji");
	assertNotNull(repository.save(admin)); //
	//  logger.info("Saved Admin User -> {}",);

	}

	@Test void updateAdminUser() { AdminUser admin =
			repository.findByAdminUserName("Raji");
	logger.info("Details of Admin User -> {}",admin);
	admin.setAdminPassword("Koushal");

	assertNotNull(repository.save(admin));

	}

	@Test

	@DirtiesContext void deleteAdminUser() {

		AdminUser admin = repository.getById(1); repository.delete(admin);


	}


}
