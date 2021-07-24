package com.sportyshoes.ecommerce.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sportyshoes.ecommerce.models.AdminUser;
import com.sportyshoes.ecommerce.service.AdminUserService;
import com.sportyshoes.ecommerce.validator.AdminUserValidator;

@Controller
public class AdminUserController {

	@Autowired
	private AdminUserService adminUserService;

	@Autowired
	private AdminUserValidator adminUserValidator;

	private Logger logger = LoggerFactory.getLogger(this.getClass());


	@RequestMapping(value = "/adminLogin",method=RequestMethod.GET)
	public String adminUserLoginPage(Model model) {

		model.addAttribute("adminUser",new AdminUser());
		return "adminLogin";

	}

	@PostMapping(value="/adminLogin")
	public String loginAdminUser(@ModelAttribute("adminUser") AdminUser adminUser,BindingResult bindingResult,HttpServletRequest request) {
		HttpSession session = request.getSession();
		adminUserService.authenticateAdminUser(adminUser, bindingResult);
		if(bindingResult.hasErrors()) {
			return "adminLogin";
		}else {
			logger.info("$$$$$$$$$$$$$$$$$ "+ adminUser.getAdminUserName() +"   @@@@ "+adminUser.toString());
			session.setAttribute("UserName", adminUser.getAdminUserName());
		}

		return "homePage";
	}

	@PostMapping(value="/registerAdmin")
	public String saveAdminUser(@ModelAttribute("adminUser") AdminUser adminUser,BindingResult bindingResult) {
		adminUserValidator.validate(adminUser, bindingResult);

		if(bindingResult.hasErrors()) {
			return "adminRegistration";
		}

		adminUserService.saveAdminUser(adminUser);
		return "welcome";
	}

	@GetMapping(value="/registerAdmin")
	public String registerPage(Model model) {
		model.addAttribute("adminUser",new AdminUser());

		return "adminRegistration";
	}

	@GetMapping(value="/home")
	public String gotoHomePage() {


		return "homePage";
	}

	@GetMapping(value="/logoutAdmin")
	public String logOutSession(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.removeAttribute("UserName");
		session.invalidate();


		return "homePage";
	}

}
