package com.virtusa.model;

import org.springframework.stereotype.Component;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*Model class contains the variables(along setters and getter methods)
corresponding to the fields exist in the database.
This will represent corporate entity.
*/


/*@Entity annotation specifies where a class is an entity and can be mapped to a table*/

/* @Table annotation species the name of the database table to be used for
* mapping
*/
@Entity
@Table(name = "CorporateModel")
@Component
public class CorporateModel {
	public CorporateModel()
	{
		
	}

	public CorporateModel(String name, String branch, String address) {
		
	
		this.name = name;
		this.branch = branch;
		this.address = address;
	}

	@Id/*@Id specifies the primary key of an entity*/
	@GeneratedValue(strategy = GenerationType.IDENTITY)//this provides for the specification of generation stratergies for primary key.
	@Column(name = "id")
	int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name")
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "branch")
	String branch;

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Column(name = "address")
	String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
