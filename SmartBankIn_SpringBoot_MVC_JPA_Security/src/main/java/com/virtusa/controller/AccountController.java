package com.virtusa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.exception.IDNotFoundException;
import com.virtusa.model.AccountModel;
import com.virtusa.model.CustomerModel;
import com.virtusa.service.AccountService;
import com.virtusa.service.CustomerService;

@Controller
public class AccountController {

	final static Logger logger = LogManager.getLogger(CorporateController.class);
	/* NOTE: if it's needed you can change methods also like ModelAndView */
	@Autowired
	AccountModel accountModel;

	@Autowired
	AccountService accountService;

	@Autowired
	CustomerModel customerModel;

	@Autowired
	CustomerService customerService;

	/*
	 * @RequestMapping("/findQuery") public String find(Model m){ String res=null;
	 * List<Object[]> list= employeeService.find(); for (Object[] obj:list)
	 * 
	 * res=obj[0]+"  "+obj[1];
	 * 
	 * m.addAttribute("res",res); return "queryForm"; }
	 */
	@RequestMapping("/AllAccounts")
	public String AllAccounts() {
		
		return "AllAccounts";
	}

	@RequestMapping("/withdrawMoney{balance}")
	public String withdrawMoney(@RequestParam double balance, HttpServletRequest request,
			HttpServletResponse response) {
		// code here
		System.out.println("./withdrawMoney" + balance);

		HttpSession session = request.getSession(false);
		System.out.println(session.getAttribute("cid"));
		accountModel.setAccount_Balance(Double.valueOf(balance));
//		int i = 1;
		int i = accountService.withdrawMoney(accountModel, session);

		if (i > 0) {
			return "redirect:/bankDetails";
		} else {
			return "ErrorLog";
		}
	}

	@RequestMapping("/withdrawForm")
	public String withdrawMoney() {
		// code here
		System.out.println("withdrawForm");
		return "withdrawForm";
	}

	@RequestMapping("/depositForm")
	public String depositForm(Model m) {
		// code here
		System.out.println("depositForm");
		m.addAttribute("accountModel", accountModel);
		return "depositForm";
	}

	@RequestMapping("/depositMoney{balance}")
	public String deposit(@RequestParam double balance, HttpServletRequest request, HttpServletResponse response) {
		// code here
		System.out.println("./depositMoney" + balance);
		HttpSession session = request.getSession(false);
		System.out.println(session.getAttribute("cid"));
		accountModel.setAccount_Balance(Double.valueOf(balance));
		/* accountService.AddMoney(accountModel, session); */
		/* int i = 1; */
		int i = accountService.AddMoney(accountModel, session);

		if (i > 0) {
			return "redirect:/bankDetails";
		} else {
			return "ErrorLog";
		}
	}

	@RequestMapping("/newBankAccount")
	public String newBankAccount(@RequestParam int cust_id, @ModelAttribute("accountModel") AccountModel account,
			CustomerModel customer) {
		System.out.println("Returning newBankAccount file : " + cust_id + "");
		customer.setCust_id(cust_id);
		account.setCustomer(customer);
		String accNum = accountService.generateAccNum(account);
		account.setAccount_num(accNum);
		logger.info("into add");
		accountService.saveAccount(account);
		return "redirect:/customersList";

	}

	@RequestMapping("/createAccount")
	public String createAccount(@RequestParam int id, Model m) {
		System.out.println("Returning createAccount file : ");
		String page = null;

		try {
			if (customerService.getCustomerById(id).isPresent()) {
				System.out.println("Returning editCustomers file customerModel : " + customerModel);
				m.addAttribute("customer", customerService.getCustomerById(id).get());
				m.addAttribute("accountModel", accountModel);
				page = "newBankAccount";

			} else if (customerService.getCustomerById(id).empty() != null) {
				throw new IDNotFoundException();
			}
		} catch (Exception ex) {
			m.addAttribute("exception", ex);
			page = "ExceptionPage";
		}

		return page;
		// "newBankAccount";

	}

	@RequestMapping("/accountSummary")
	public String accountSummary() {
		// code here
		System.out.println("accountSummary");
		return "AccountSummary";
	}

}
