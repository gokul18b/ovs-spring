package com.ovs.service.voter;

import java.util.List;

import com.ovs.dao.EmployeeResponse;

public interface VoterService {

	List<EmployeeResponse> get_employees();
	
	List<EmployeeResponse> get_students();
}
