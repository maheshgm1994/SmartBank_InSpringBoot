package com.virtusa;

import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.virtusa.model.CorporateModel;
import com.virtusa.repository.CorporateRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CorporateRepositoryTest {

	@Autowired
	CorporateRepository corporateRepository;

	static CorporateModel c;

	int id;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		c = new CorporateModel("testabc", "testbranch", "testaddress");

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	@Rollback(false)
	public void saveCorporateTest() {
		corporateRepository.save(c);
		id = c.getId();
		Assertions.assertNotNull(c.getId());
	}

	@Test
	@Rollback(false)
	public void findByIdTest() {
		Optional<CorporateModel> corp = corporateRepository.findById(id);
		Assertions.assertEquals("testabc", c.getName());
	}

	@Test
	@Rollback(false)
	public void deleteCorporateTest() {
		id = c.getId();
		corporateRepository.delete(c);
		Assertions.assertNotNull(c.getId());
	}

	@Test
	@Rollback(false)
	public void findAllCorporateTest() {
		corporateRepository.save(c);
		Assertions.assertNotNull(corporateRepository.findAll());
	}

}
