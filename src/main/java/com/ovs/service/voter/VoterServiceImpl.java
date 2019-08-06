package com.ovs.service.voter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ovs.dao.voter.VoterDao;
import com.ovs.model.Voter;

@Service
@Transactional
public class VoterServiceImpl implements VoterService {

	@Autowired
	VoterDao voterDao;

	@Transactional
	@Override
	public long add_voter(Voter voter) {
		// TODO Auto-generated method stub
		return voterDao.add_voter(voter);
	}

	@Override
	public Voter get_voter(int id) {
		// TODO Auto-generated method stub
		return voterDao.get_voter(id);
	}

	@Override
	public List<Voter> get_voter_all() {
		// TODO Auto-generated method stub
		return voterDao.get_all();
	}

	@Override
	public void update_voter(int id, Voter voter) {
		// TODO Auto-generated method stub
		voterDao.update_voter(id, voter);
	}

	@Override
	public void delete_voter(int id) {
		// TODO Auto-generated method stub
		voterDao.delete_voter(id);
	}

	@Override
	public 	List<Voter> get_active_voters() {
		// TODO Auto-generated method stub
		return voterDao.get_active_voters();
	}

}
