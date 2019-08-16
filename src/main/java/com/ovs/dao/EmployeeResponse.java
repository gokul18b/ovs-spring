package com.ovs.dao;

public class EmployeeResponse {
	private String name;
	private String deptname;

	public EmployeeResponse() {

	}

	public EmployeeResponse(String name, String deptname) {
		super();
		this.name = name;
		this.deptname = deptname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

}
