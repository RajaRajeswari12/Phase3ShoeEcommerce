package com.sportyshoes.ecommerce.service.implementation;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sportyshoes.ecommerce.models.PurchaseReport;
import com.sportyshoes.ecommerce.repository.PurchaseReportRepository;
import com.sportyshoes.ecommerce.service.PurchasedReportService;

@Service
public class PurchasedReportServiceImpl implements PurchasedReportService{

	@Autowired
	private PurchaseReportRepository purchasedReportService;
	
	@Override
	public Page<PurchaseReport> reportPagination(int pageNo, int reportCount) {
		Pageable pageable = PageRequest.of(pageNo-1, reportCount);
		return this.purchasedReportService.findAll(pageable);
	}

	@Override
	public Page<PurchaseReport> purchasedReportByCategoryPagination(int categoryId,int pageNo, int reportCount) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNo-1, reportCount);
		return purchasedReportService.findByCategory(categoryId,pageable);
	}

	@Override
	public Page<PurchaseReport> purchasedReportByDatePaginationt(Date purchasedDate, int pageNo, int reportCount) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNo-1, reportCount);
		return purchasedReportService.findByDate(purchasedDate,pageable);
	}

}
