package com.sportyshoes.ecommerce.repository;


import java.util.Date;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.sportyshoes.ecommerce.models.PurchaseReport;

@Repository
public interface PurchaseReportRepository extends JpaRepository<PurchaseReport, Integer>{
	
	Page<PurchaseReport> findByCategory(int categoryId,Pageable pageable);
	
	Page<PurchaseReport> findByDate(Date purchasedDate,Pageable pageable);
	
	@Modifying
	void deleteByProductId(int productId);
}
