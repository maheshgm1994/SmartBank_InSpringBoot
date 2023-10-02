package com.virtusa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.sun.istack.NotNull;

@Entity
@Table(name = "CustomerModel")
@Component
public class CustomerModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cust_id")
	private int cust_id;

	private String gender, cust_address, cust_type, cust_corpName, isActive, isAdmin;
	
    public CustomerModel() 
    {
		
	}
	public CustomerModel(String gender, String cust_address, String cust_type, String cust_corpName, String isActive,
			String isAdmin, String cust_name, String cust_email, String password) {
		//super();
		this.gender = gender;
		this.cust_address = cust_address;
		this.cust_type = cust_type;
		this.cust_corpName = cust_corpName;
		this.isActive = isActive;
		this.isAdmin = isAdmin;
		this.cust_name = cust_name;
		this.cust_email = cust_email;
		this.password = password;
	}
	private String cust_name;

	

	@Column(unique = true)
	private String cust_email;

	private String password;
	
	@OneToOne(mappedBy = "customer")
	private AccountModel accountModel;

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public boolean valid;

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isValid() {
		return valid;
	}

	public String getCust_email() {
		return cust_email;
	}

	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}

	public String getCust_address() {
		return cust_address;
	}

	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}

	public String getCust_type() {
		return cust_type;
	}

	public void setCust_type(String cust_type) {
		this.cust_type = cust_type;
	}

	public String getCust_corpName() {
		return cust_corpName;
	}

	public void setCust_corpName(String cust_corpName) {
		this.cust_corpName = cust_corpName;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public AccountModel getAccountModel() {
		return accountModel;
	}

	public void setAccountModel(AccountModel accountModel) {
		this.accountModel = accountModel;
	}

}
