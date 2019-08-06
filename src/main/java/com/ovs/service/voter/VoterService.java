package com.ovs.service.voter;

import java.util.List;

import com.ovs.model.Voter;

public interface VoterService {

	long add_voter(Voter voter);
	
	Voter get_voter(int id);
	
	List<Voter> get_voter_all();
	
	void update_voter(int id,Voter voter);
	
	void delete_voter(int id);
	List<Voter> get_active_voters();
}
