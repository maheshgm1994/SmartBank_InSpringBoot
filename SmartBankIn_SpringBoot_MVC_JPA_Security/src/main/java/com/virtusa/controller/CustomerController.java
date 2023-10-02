package com.virtusa.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.exception.IDNotFoundException;
import com.virtusa.model.CustomerModel;
import com.virtusa.service.CustomerService;

@Controller
public class CustomerController {

	final static Logger logger = LogManager.getLogger(CorporateController.class);
	@Autowired
	public CustomerService customerService;

	@Autowired
	public CustomerModel customerModel;

	@RequestMapping("/")
	public String index() {
		System.out.println("Returning index file");
		return "loginPage";
	}

	@RequestMapping("/customersList")
	public String displayCustomers(Model m) {
		List<CustomerModel> AllCust = customerService.listAll();
		m.addAttribute("AllCust", AllCust);

		for (CustomerModel list : AllCust) {
			System.out.println("list : " + list.getCust_id() + "" + list.getCust_name());
		}
		return "AllCustomers";
	}

	@RequestMapping("/NewCustomer")
	public String newCustomers(Model m) {
		System.out.println("Returning NewCustomers file");
		logger.info("into add");
		m.addAttribute("custModel", customerModel);
		return "createCustomer";
	}

	/*
	 * @RequestMapping(value = "/addContact") public ModelAndView
	 * addStudent(@ModelAttribute("contact") Contact contact1) { ModelAndView model1
	 * = new ModelAndView("final"); return model1; }
	 */

	@RequestMapping("/registerCustomer")
	public String registerCustomer(@ModelAttribute("custModel") CustomerModel customerModel) {
		System.out.println("registerCustomer " + customerModel.getCust_name());
		customerService.saveCustomer(customerModel);
		return "redirect:/customersList";
	}

	@RequestMapping("/editCustomer{id}")
	public String editCustomer(@RequestParam int id, Model m) {
		System.out.println("Returning editCustomers  : " + id);
		String page = null;
		try {
			if (customerService.getCustomerById(id).isPresent()) {
				System.out.println("Returning editCustomers file customerModel : " + customerModel);
				m.addAttribute("custModel", customerService.getCustomerById(id).get());
				page = "editCustomer";
			} else if (customerService.getCustomerById(id).empty() != null) {
				System.out.println("customerModel " + customerModel);
				throw new IDNotFoundException();

			}

		} catch (Exception ex) {
			m.addAttribute("exception", ex);
			page = "ExceptionPage";
		}

		return page;
	}

	/*
	 * @RequestMapping("/editCustomer{id}") public String editCustomer(@RequestParam
	 * int id, Model m) { System.out.println("Returning editCustomers file : " +
	 * id); CustomerModel customer = customerService.getById(id);
	 * System.out.println("Returning editCustomers file customerModel : " +
	 * customerModel); m.addAttribute("custModel", customer);
	 * 
	 * return "editCustomer"; }
	 */

	@RequestMapping("/updateCustomer")
	public String updateCustomer(@ModelAttribute("custModel") CustomerModel customer) {
		System.out.println("Returning updateCustomers file : " + customerModel.getCust_email());
		customerService.saveCustomer(customer);
		return "redirect:/customersList";

	}

	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
	public String deleteCustomer(@RequestParam int id, CustomerModel customerModel, Model m) {
		System.out.println("Returning deleteCustomer file");
		System.out.println("id : " + id);
		String page = "";
		try {
			if (customerService.getCustomerById(id).isPresent()) {
				System.out.println("Returning deleteCustomer file customerModel : " + customerModel);
				customerModel = customerService.getCustomerById(id).get();
				customerService.deleteCustomer(customerModel);

				page = "redirect:/customersList";

			} else if (customerService.getCustomerById(id).empty() != null) {
				System.out.println("customerModel " + customerModel);
				throw new IDNotFoundException();
			}

		} catch (Exception ex) {
			m.addAttribute("exception", ex);
			page = "ExceptionPage";
		}

		return page;

	}

	@RequestMapping("/bankDetails")
	public String customerBankDetails() {
		System.out.println("Returning customerBankDetails file");
		return "customerBankDetails";
	}

}
