package com.virtusa.controller;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.virtusa.model.CustomerModel;
import com.virtusa.service.CustomerService;

@Controller
public class LoginLogoutController {

	@Autowired
	public CustomerModel custModel;
	@Autowired
	CustomerService customerService;

	/*
	 * @RequestMapping("/loginForm") public String loginForm() {
	 * System.out.println("loginForm hitting... and return loginPage"); return
	 * "loginPage"; }
	 */

	@RequestMapping("/login")
	public String Login(@RequestParam String email, @RequestParam String pswd, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		System.out.println("Hello Am try to Login..." + email + " and " + pswd);
		try {
			custModel.setCust_email(email);
			custModel.setPassword(pswd);

			List<CustomerModel> customer = customerService.getLogDetails(email, pswd);

			for (CustomerModel cust : customer) {

				System.out.println("Is Admin ? : " + cust.getIsAdmin());

				session.setAttribute("email", cust.getCust_email());
				session.setAttribute("isAdmin", cust.getIsAdmin());
				session.setAttribute("userName", cust.getCust_name());
				session.setAttribute("cid", cust.getCust_id());

			}
			System.out.println("session in spring boot : " + session.getAttribute("email"));
			System.out.println("session in spring boot : " + session.getAttribute("isAdmin"));

			return "index";

		}

		catch (Throwable theException) {
			System.out.println(theException);
		}

		return "redirect:/";
	}

	@RequestMapping("/logout")
	public String Logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		System.out.println("Bye Am Logout...");
		session.invalidate();
		return "loginPage";
	}

}