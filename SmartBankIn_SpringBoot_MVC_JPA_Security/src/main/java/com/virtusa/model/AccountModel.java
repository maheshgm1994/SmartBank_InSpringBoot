package com.virtusa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "account_model")
@Component
public class AccountModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private int account_id;
	
	public AccountModel() {}
	public AccountModel(String account_branch, String account_type, String account_num, double account_Balance) {
		
		this.account_branch = account_branch;
		this.account_type = account_type;
		this.account_num = account_num;
		this.account_Balance = account_Balance;
		
	}

	private String account_branch;
	private String account_type;
	private String account_num;
	private double account_Balance;
	/*
	 * @OneToOne(cascade = {CascadeType.ALL})
	 * 
	 * @JoinColumn(name = "account_cust", referencedColumnName = "cust_id", unique =
	 * true, nullable = false)
	 */
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_cust", unique = true, nullable = false)
	private CustomerModel customer;

	public CustomerModel getCustomer() {
		System.out.println("getCustomer ... ");
		return customer;
	}

	public void setCustomer(CustomerModel customer) {
		System.out.println("setCustomer ... ");
		this.customer = customer;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int accunt_id) {
		this.account_id = accunt_id;
	}

	public String getAccount_branch() {
		return account_branch;
	}

	public void setAccount_branch(String account_branch) {
		this.account_branch = account_branch;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public String getAccount_num() {
		return account_num;
	}

	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}

	public double getAccount_Balance() {
		return account_Balance;
	}

	public void setAccount_Balance(double account_Balance) {
		this.account_Balance = account_Balance;
	}

}
