package com.sportyshoes.ecommerce.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.sportyshoes.ecommerce.POJO.CustomerNamePOJO;
import com.sportyshoes.ecommerce.POJO.PurchaseReportByDatePOJO;
import com.sportyshoes.ecommerce.models.ProductCategory;
import com.sportyshoes.ecommerce.models.PurchaseReport;
import com.sportyshoes.ecommerce.service.ProductCategoryService;
import com.sportyshoes.ecommerce.service.PurchasedReportService;

@Controller
public class PurchaseReportController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PurchasedReportService purchaseReportService;
	
	@Autowired
	private ProductCategoryService productCategoryService;
	
	@GetMapping("/viewAllReport")
	public String viewAllUserListe(Model model) {
		return paginateReport(1,model);
	}
	
	@GetMapping("/report/{pageNo}")
	public String paginateReport(@PathVariable(value="pageNo") int pageNo,Model model) 
	{		
		int reportCount = 5;
		Page<PurchaseReport> page = purchaseReportService.reportPagination(pageNo, reportCount);
		List<PurchaseReport> listOfPurchaseReport = page.getContent();		
		model.addAttribute("activePage",pageNo);
		model.addAttribute("totalPages",page.getTotalPages());
		model.addAttribute("listOfPurchaseReport",listOfPurchaseReport);
		return "viewPurchaseReport";
	}

	@GetMapping("/viewReportByCategoryNm")
	public String gotoSearchPurchaseReportsByCategoryPage(Model model) 
	{
		
		List<ProductCategory> productCategoryList = productCategoryService.getAllProductCategory(); 
		model.addAttribute("productCategoryList",productCategoryList);
		model.addAttribute("lastselected", 21);
		return "searchPurchaseReportsByCategory";
	}
	
	@GetMapping("/getByCategory")
	public String getByCategory(Model model,@RequestParam("categoryId") int categoryId ) {
		
		logger.info("----------------"+categoryId);
		
		
		return paginateReportByCategory(1,model,categoryId);
		
	}
	
	@GetMapping("/categoryReport/{pageNo}")
	public String paginateReportByCategory(@PathVariable(value="pageNo") int pageNo,Model model,int categoryId ) 
	{		
		int reportCount = 5;
		Page<PurchaseReport> page = purchaseReportService.purchasedReportByCategoryPagination(categoryId,pageNo, reportCount);
		List<PurchaseReport> listOfPurchaseReport = page.getContent();		
		model.addAttribute("activePage",pageNo);
		model.addAttribute("totalPages",page.getTotalPages());
		model.addAttribute("listOfPurchaseReport",listOfPurchaseReport);
		return "viewPurchaseReport";
	}
	
	
	@GetMapping("/viewReportByDate")
	public String gotoSearchPurchaseReportsByDate(Model model) 
	{		
		model.addAttribute("purchaseReportByDatePOJO",new PurchaseReportByDatePOJO());
		return "searchPurchaseReportsByDate";
	}
	
	@GetMapping("/getByDate")
	public String getByDate(Model model,@RequestParam("purchaseDt") String purchasedDate ) throws ParseException {
		
		logger.info("----------------"+purchasedDate);
		Date parseDate=new SimpleDateFormat("dd/MM/yyyy").parse(purchasedDate);  
		
		return paginateReportByDate(1,model,parseDate);
		
	}
	
	@GetMapping("/dateReport/{pageNo}")
	public String paginateReportByDate(@PathVariable(value="pageNo") int pageNo,Model model,Date purchasedDate ) 
	{		
		int reportCount = 5;
		Page<PurchaseReport> page = purchaseReportService.purchasedReportByDatePaginationt(purchasedDate,pageNo, reportCount);
		List<PurchaseReport> listOfPurchaseReport = page.getContent();		
		model.addAttribute("activePage",pageNo);
		model.addAttribute("totalPages",page.getTotalPages());
		model.addAttribute("listOfPurchaseReport",listOfPurchaseReport);
		return "viewPurchaseReport";
	}


}
