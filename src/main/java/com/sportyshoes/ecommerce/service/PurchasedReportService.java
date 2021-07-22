package com.sportyshoes.ecommerce.service;

import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;


import com.sportyshoes.ecommerce.models.PurchaseReport;

@Transactional
public interface PurchasedReportService {
	
	Page<PurchaseReport> reportPagination(int pageNo,int reportCount);
	
	

	Page<PurchaseReport> purchasedReportByCategoryPagination(int categoryId, int pageNo, int reportCount);
	
	Page<PurchaseReport> purchasedReportByDatePaginationt(Date purchasedDate, int pageNo, int reportCount);

}
