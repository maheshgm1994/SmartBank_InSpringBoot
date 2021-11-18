package com.virtusa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.model.CorporateModel;
import com.virtusa.repository.CorporateRepository;

/*@Service annotation is specialization of @Component annotation.
It can be applied only to classes that provide some business functionalities.
It is used to mark the class as a service provider.
*/
@Service
public class CorporateService {

	@Autowired
	CorporateRepository corporateRepository;
	/* methods of crud repository to save,delete,viewall */
	public void saveCorporateModel(CorporateModel corporate) {
		corporateRepository.save(corporate);
	}

	public Optional<CorporateModel> getCorporateById(int id) {
		System.out.println("into");
		return corporateRepository.findById(id);//findById() it retrieves entity by its id.
	}

	public void deleteCorporateModel(CorporateModel corporate) {
		corporateRepository.delete(corporate);
	}

	public List<CorporateModel> viewAll() {
		List<CorporateModel> corporate = corporateRepository.findAll();//findAll() method returns the list of all corporates from the database.
		return corporate;
	}
}
