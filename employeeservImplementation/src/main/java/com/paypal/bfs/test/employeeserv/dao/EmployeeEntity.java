package com.paypal.bfs.test.employeeserv.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class EmployeeEntity {
	
	
	private int id;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String  address_line_1;
	private String  address_line_2;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	

	public EmployeeEntity(){

	}
	

	public EmployeeEntity(int id, String firstName, String lastName, Date dateOfBirth, String address_line_1,
			String address_line_2, String city, String state, String country, String zipcode) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.address_line_1 = address_line_1;
		this.address_line_2 = address_line_2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
	}





	@Id	
	@Column(name= "id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "date_of_bitth")
	public Date getEmailId() {
		return dateOfBirth;
	}
	public void setEmailId(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "address_line_1", nullable = false)
	public String getAddress_line_1() {
		return address_line_1;
	}

	
	public void setAddress_line_1(String address_line_1) {
		this.address_line_1 = address_line_1;
	}

	@Column(name = "address_line_2")
	public String getAddress_line_2() {
		return address_line_2;
	}


	public void setAddress_line_2(String address_line_2) {
		this.address_line_2 = address_line_2;
	}

	@Column(name = "city")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name = "state")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Column(name = "country")
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Column(name = "zipcode")
	public String getZipcode() {
		return zipcode;
	}
	
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


}
