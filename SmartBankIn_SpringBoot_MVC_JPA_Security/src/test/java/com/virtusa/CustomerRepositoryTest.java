package com.virtusa;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.virtusa.model.CustomerModel;
import com.virtusa.repository.CustomerRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryTest {

	@Autowired
	CustomerRepository customerRepository;

	static CustomerModel c;

	int id;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		c = new CustomerModel("testgen", "testaddress", "testtype", "testcorpname", "testactive", "testadmin",
				"testcustname", "testcustemail", "testpass");

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	@Rollback(false)
	public void saveCustomerTest() {
		customerRepository.save(c);
		id = c.getCust_id();
		Assertions.assertNotNull(c.getCust_id());
	}

	@Test
	@Rollback(false)
	public void findByIdTest() {
		Optional<CustomerModel> cus = customerRepository.findById(id);
		Assertions.assertEquals("testcustname", c.getCust_name());
	}

	@Test
	@Rollback(false)
	public void deleteCustomerTest() {
		id = c.getCust_id();
		customerRepository.delete(c);
		Assertions.assertNotNull(c.getCust_id());
	}

	@Test
	@Rollback(false)
	public void findAllCustomerTest() {
		customerRepository.save(c);
		Assertions.assertNotNull(customerRepository.findAll());
	}
}
