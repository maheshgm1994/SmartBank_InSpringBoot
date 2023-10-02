package com.virtusa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.virtusa.model.CustomerModel;
import com.virtusa.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public void saveCustomer(CustomerModel customerModel) {
		System.out.println("saveCustomer");
		customerRepository.save(customerModel);

	}

	public List<CustomerModel> listAll() {
		System.out.println("listAll");
		return customerRepository.findAll();

	}

	public Optional<CustomerModel> getCustomerById(int id) {

		System.out.println("getCustomerById");
		return customerRepository.findById(id);

	}

	public void deleteCustomer(CustomerModel customerModel)

	{
		System.out.println("deleteCustomer");
		customerRepository.delete(customerModel);

	}

	public List<CustomerModel> getLogDetails(String email, String pswd) {
		// TODO Auto-generated method stub
		System.out.println("getting getLogDetails");
		return customerRepository.findByEmail(email, pswd);
	}

}
