package com.virtusa.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.virtusa.exception.IDNotFoundException;
import com.virtusa.model.CorporateModel;
import com.virtusa.model.CustomerModel;
import com.virtusa.service.CorporateService;

//using @Controller annotation,we can have multi-actions controller class that is able to serve multiple different requests. 
@Controller
public class CorporateController {

	final static Logger logger = LogManager.getLogger(CorporateController.class);
	@Autowired
	CorporateService corporateService;

	@Autowired
	CorporateModel corporateModel;

	/*
	 * It displays a form to input data,here "corpoModel" is a reserved request
	 * attribute which is used to display object data into form
	 */
	/* @RequestMapping annotation is used for specifying URL mapping. */
	@RequestMapping("/NewCorporate")
	public String NewCorporate(Model m) {
		System.out.println("Returning CorporatesForm file");
		logger.info("into add");
		m.addAttribute("corpoModel", corporateModel);
		return "CorporateForm";
	}

	// list of all corporates in model object.
	@RequestMapping("/corporateList")
	public String displayCorporate(Model m) {
		List<CorporateModel> AllCorp = corporateService.viewAll();
		m.addAttribute("AllCorp", AllCorp);

		for (CorporateModel list : AllCorp) {
			System.out.println("list : " + list.getId() + "" + list.getName());
		}

		return "Corporatelist";
	}

	/*
	 * This will save object into database.The Model attribute puts request data
	 * into model object.Here we mentioned RequestMethod.POST method because default
	 * request is GET
	 */
	@RequestMapping(value = "/registerCorporate", method = RequestMethod.POST)
	public String registerCorproate(@ModelAttribute("corpModel") CorporateModel corporate) {
		System.out.println("registerCorporate " + corporateModel.getName());
		// logger.error("emp obj null");
		// logger.error("Saving emp object"+employee);
		corporateService.saveCorporateModel(corporate);
		return "redirect:/corporateList";// will redirect to corporatList request mapping

	}

	// It displays object data into form for the given id.
	@RequestMapping("/editCorporate{id}")
	public String edit(@RequestParam("id") int id, Model m, CorporateModel corpo) {
		String page = null;
		try {
			if (corporateService.getCorporateById(id).isPresent()) {
				corpo = corporateService.getCorporateById(id).get();
				m.addAttribute("corpoModel", corpo);
				page = "editCorporate";
			} else if (corporateService.getCorporateById(id).empty() != null) {
				throw new IDNotFoundException();
			}
		} catch (IDNotFoundException e) {
			m.addAttribute("exception", e);
			page = "ExceptionPage";
		}
		return page;
	}

	/* It updates model object. */
	@RequestMapping("/updateCorporate")
	public String updateCorporate(@ModelAttribute("corpModel") CorporateModel corporate) {
		System.out.println("Returning updateCorporate file : " + corporate.getAddress() + "" + corporate.getId());

		corporateService.saveCorporateModel(corporate);
		return "redirect:/corporateList";// will redirect to corporateList request mapping

	}

	/* delete the record for the given id in url and redirects to corporateList */

	/*
	 * public String delete(@PathVariable int id, CorporateModel corporate, Model m)
	 * { System.out.println("deleteCorporate"); String page = ""; try { if
	 * (corporateService.getCorporateById(id).isPresent()) { corporate =
	 * corporateService.getCorporateById(id).get();
	 * corporateService.deleteCorporateModel(corporate);
	 * 
	 * page = "redirect:/corporateList"; } else if
	 * (corporateService.getCorporateById(id).empty() != null) {
	 * System.out.println("corpoModel " + corporate); throw new
	 * IDNotFoundException();
	 * 
	 * } } catch (IDNotFoundException c) { m.addAttribute("exception", c); page =
	 * "ExceptionPage"; } return page; }
	 */

	@RequestMapping(value = "/deleteCorporate", method = RequestMethod.GET)
	public String delete(@RequestParam int id, CorporateModel corporate, Model m) {
		System.out.println("deleteCorporate");
		String page = null;
		try {
			if (corporateService.getCorporateById(id).isPresent()) {
				corporate = corporateService.getCorporateById(id).get();
				corporateService.deleteCorporateModel(corporate);
				page = "redirect:/corporateList";
			} else {
				System.out.println("corpoModel " + corporate);
				throw new IDNotFoundException();

			}
		} catch (IDNotFoundException c) {
			m.addAttribute("exception", c);
			page = "ExceptionPage";
		}
		return page;
	}
}
