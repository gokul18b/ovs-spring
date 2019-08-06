package com.ovs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ovs.model.Voter;
import com.ovs.service.voter.VoterService;

@RestController
@RequestMapping("/voter")
public class VoterController {
	@Autowired
	VoterService voterService;

	@PostMapping("/add_voter")
	public ResponseEntity<?> add_voter(@RequestBody Voter voter) {
		long id = voterService.add_voter(voter);
		return ResponseEntity.ok().body("New Voter has been saved with ID:" + id);
	}

	@GetMapping("/get_voter/{id}")
	public ResponseEntity<Voter> get_voter(@PathVariable("id") int id) {
		return ResponseEntity.ok().body(voterService.get_voter(id));
	}

	@GetMapping("/get_all")
	public ResponseEntity<List<Voter>> get_all_voter() {
		return ResponseEntity.ok().body(voterService.get_voter_all());
	}

	@PutMapping("/update_voter/{id}")
	public ResponseEntity<?> update_voter(@PathVariable("id") int id, @RequestBody Voter voter) {
		voterService.update_voter(id, voter);
		return ResponseEntity.ok().body("Succesfully updated");
	}

	@DeleteMapping("/delete_voter/{id}")
	public ResponseEntity<?> delete_voter(@PathVariable("id") int id) {
		voterService.delete_voter(id);
		return ResponseEntity.ok().body("Succesfully updated");
	}
	
	
	@GetMapping("/get_active_voters")
	public ResponseEntity<List<Voter>> get_active_voters(){
		return ResponseEntity.ok().body(voterService.get_active_voters());
	}
}
