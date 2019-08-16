package com.ovs.dao.voter;

import java.util.List;

import com.ovs.dao.EmployeeResponse;

public interface VoterDao {
	List<EmployeeResponse> get_employees();
	List<EmployeeResponse> get_students();
	

}
