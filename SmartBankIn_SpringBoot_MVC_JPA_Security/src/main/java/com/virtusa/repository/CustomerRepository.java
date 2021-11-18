package com.virtusa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.virtusa.model.CustomerModel;

//@EnableJpaRepositories
public interface CustomerRepository extends JpaRepository<CustomerModel, Integer> {

	@Query(value = "select * from customer_model where cust_email=:email AND password=:pswd", nativeQuery = true)
	List<CustomerModel> findByEmail(@Param("email") String email, @Param("pswd") String pswd);

}
