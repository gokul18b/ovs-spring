package com.ovs.service.voter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ovs.dao.EmployeeResponse;
import com.ovs.dao.voter.VoterDao;

@Service
@Transactional
public class VoterServiceImpl implements VoterService {

	@Autowired
	VoterDao voterDao;

	@Override
	public List<EmployeeResponse> get_employees() {
		// TODO Auto-generated method stub
		return voterDao.get_employees();
	}

	@Override
	public List<EmployeeResponse> get_students() {
		// TODO Auto-generated method stub
		return voterDao.get_students();
	}

	

	
}
