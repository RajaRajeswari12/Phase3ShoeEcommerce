package com.sportyshoes.ecommerce.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sportyshoes.ecommerce.models.PurchaseReport;

public interface PurchaseReportRepository extends JpaRepository<PurchaseReport, Integer>{
	
	Page<PurchaseReport> findByCategory(int categoryId,Pageable pageable);
	
	Page<PurchaseReport> findByDate(Date purchasedDate,Pageable pageable);

}
