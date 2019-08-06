package com.ovs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Voter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "aadhar_number")
	private String aadharNo;
	@Column(name = "mobile_number")
	private String mobileNumber;
	@Column(name = "address")
	private String address;
	@Column(name = "status")
	private int status;
	

	public Voter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Voter(String firstName, String lastName, String aadharNo, String mobileNumber, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.aadharNo = aadharNo;
		this.mobileNumber = mobileNumber;
		this.address = address;
	}
	

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Voter [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", aadharNo=" + aadharNo
				+ ", mobileNumber=" + mobileNumber + ", address=" + address + "]";
	}

}
